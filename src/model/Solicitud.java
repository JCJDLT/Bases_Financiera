package model;

public class Solicitud {
	private int id;
	private int cedulaCliente;
	private double interes;
	private double monto;
	private int idProducto;
	private String nombreCliente;
	private String nombreProducto;
	private int tiempo;

	public Solicitud(int id, int cedulaCliente, double interes, double monto, int idProducto, String nombreCliente,
			String nombreProducto, int tiempo) {
		super();
		this.id = id;
		this.cedulaCliente = cedulaCliente;
		this.interes = interes;
		this.monto = monto;
		this.idProducto = idProducto;
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
		this.tiempo = tiempo;
	}

	public Solicitud() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
