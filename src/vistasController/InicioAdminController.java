package vistasController;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import controller.ModelFactoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Solicitud;

public class InicioAdminController implements Initializable {
	
    @FXML
    private Label nombre;
    
    @FXML
    private TableView<Solicitud> tableSolicitudes;

    @FXML
    private TableColumn<Solicitud, Integer> idSolCol;

    @FXML
    private TableColumn<Solicitud, Integer> cedulaCol;
    
    @FXML
    private TableColumn<Solicitud, String> idNombreCol;

    @FXML
    private TableColumn<Solicitud, Double> interesCol;

    @FXML
    private TableColumn<Solicitud, Double> montoCol;

    @FXML
    private TableColumn<Solicitud, Integer> idProdCol;
    
    @FXML
    private TableColumn<Solicitud, String> idNombrePCol;
    
    @FXML
    private TableColumn<Solicitud, Integer> tiempo;
    
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    
    private ObservableList<Solicitud> observableListSol = FXCollections.observableList(mfc.getListaSolicitudes());
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		nombre.setText(mfc.obtenerNombreEmpleadoLogueado());
		mfc.obtenerSolicitudes();
		idSolCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		cedulaCol.setCellValueFactory(new PropertyValueFactory<>("cedulaCliente"));
		idNombreCol.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
		interesCol.setCellValueFactory(new PropertyValueFactory<>("interes"));
		montoCol.setCellValueFactory(new PropertyValueFactory<>("monto"));
		idProdCol.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
		idNombrePCol.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
		tiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
		tableSolicitudes.setItems(observableListSol);
	}

	@FXML
    void simularCredito() {
		int idSolicitud = tableSolicitudes.getSelectionModel().getSelectedItem().getId();
		mfc.setidSolicitud(idSolicitud);
		if(tableSolicitudes.getSelectionModel().getSelectedItem() != null) {
			mfc.crearAmortizacion(tableSolicitudes.getSelectionModel().getSelectedItem().getMonto(),tableSolicitudes.getSelectionModel().getSelectedItem().getTiempo(),tableSolicitudes.getSelectionModel().getSelectedItem().getInteres());
			mfc.getMain().abrirPaginaSimulacion();
			initialize(null, null);
			tableSolicitudes.refresh();
		}else {
			JOptionPane.showMessageDialog( null, "Selecciones una solicitud" );
		}
    }
}
