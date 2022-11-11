package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import application.Aplicacion;
import model.Amortizacion;
import model.Solicitud;
import model.UniBanco;

public class ModelFactoryController {
	private Aplicacion main;

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private UniBanco unibanco = new UniBanco();
	private int personaLogeada;

	// ------------------------------ Singleton
	// ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		abrirConexion();
	}

	public final void abrirConexion() {
		try { // servidor //usuario //clave

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "FINANCIERA", "root");
			stmt = con.createStatement();
			// ResultSet rs=stmt.executeQuery("use PRUEBA;");
			System.out.println("Connected");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public final void cerrarConexion() {
		try {
			// System.out.println("DESCONECTADO");
			stmt.close();
			con.close();
			rs.close();
			System.out.println("DESCONECTADO");
		} catch (SQLException ex) {
			Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int validarLogin(String correo, String clave) {
		try {
			String query = "select e.cedula,e.email,e.clave,c.id_cargo from empleado@enlaceClientes e join cargo@enlaceClientes c on e.cargo_id_cargo = c.id_cargo";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (correo.equalsIgnoreCase(rs.getString("EMAIL")) && clave.equals(rs.getString("CLAVE"))) {
					personaLogeada = rs.getInt("CEDULA");
					return rs.getInt("ID_CARGO");
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}

	public String obtenerNombreEmpleadoLogueado() {
		try {
			String query = "select e.nombre from empleado@enlaceClientes e WHERE e.cedula =" + personaLogeada;
			rs = stmt.executeQuery(query);
			rs.next();
			return rs.getString(1);
		} catch (SQLException ex) {
			Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public void obtenerSolicitudes() {
		unibanco.getListaSolicitudes().clear();
		try {
			String query = "select s.idsolicitud,s.cedula_cliente,c.nombre,s.interes,s.monto,s.id_producto,p.nombre,s.tiempo from solicitud s join cliente@enlaceClientes c on s.cedula_cliente = c.cedula join producto@enlaceClientes p\r\n"
					+ "on s.id_producto = p.id_producto where s.estado is null";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Solicitud solicitud = new Solicitud();
				solicitud.setId(rs.getInt(1));
				solicitud.setCedulaCliente(rs.getInt(2));
				solicitud.setNombreCliente(rs.getString(3));
				solicitud.setInteres(rs.getDouble(4));
				solicitud.setMonto(rs.getDouble(5));
				solicitud.setIdProducto(rs.getInt(6));
				solicitud.setNombreProducto(rs.getString(7));
				solicitud.setTiempo(rs.getInt(8));
				unibanco.getListaSolicitudes().add(solicitud);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void respuestaSolicitud(char respuesta) {
		try {
			String query = "UPDATE Solicitud SET cedula_analista ="+personaLogeada+", estado ="+respuesta+" where idsolicitud ="+unibanco.getIdSolicitud()+"";
			stmt.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public UniBanco getUnibanco() {
		return unibanco;
	}

	public void setUnibanco(UniBanco unibanco) {
		this.unibanco = unibanco;
	}

	public Aplicacion getMain() {
		return main;
	}

	public void setMain(Aplicacion main) {
		this.main = main;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ArrayList<Solicitud> getListaSolicitudes() {
		// TODO Auto-generated method stub
		return unibanco.getListaSolicitudes();
	}

	public ArrayList<Amortizacion> getListaAmortizacion() {
		// TODO Auto-generated method stub
		return unibanco.getListaAmortizacion();
	}
	
	public void setidSolicitud(int idSolicitud) {
		unibanco.setIdSolicitud(idSolicitud);
	}

	public void crearAmortizacion(double principal, int length, double interest) {
		unibanco.getListaAmortizacion().clear();
		double monthlyInterest = interest / (12 * 100);
		double monthlyPayment = principal * (monthlyInterest / (1 - Math.pow((1 + monthlyInterest), (length * -1))));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		for (int x = 1; x <= length; x++) {
			Amortizacion amortizacion = new Amortizacion();
			double amountInterest = principal * monthlyInterest;
			double amountPrincipal = monthlyPayment - amountInterest;
			principal = principal - amountPrincipal;
			amortizacion.setMeses(String.valueOf(x)+" Mes");
			amortizacion.setCouta(nf.format(monthlyPayment));
			amortizacion.setAmortizacion(nf.format(amountPrincipal));
			amortizacion.setInteres(nf.format(amountInterest));
			amortizacion.setBalance(nf.format(principal));
			unibanco.getListaAmortizacion().add(amortizacion);
		}
	}
}
