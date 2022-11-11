package vistasController;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import controller.ModelFactoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Amortizacion;

public class AmortizacionController implements Initializable {

//	@FXML
//	private TableView<Amortizacion> amortizacion;
//
//	@FXML
//	private TableColumn<Amortizacion,Integer> mesCOL;
//
//	@FXML
//	private TableColumn<Amortizacion,Double> coutaCOL;
//
//	@FXML
//	private TableColumn<Amortizacion,Double> amorCOL;
//
//	@FXML
//	private TableColumn<Amortizacion,Double> interesCOL;
//
//	@FXML
//	private TableColumn<Amortizacion,Double> balanceCOL;
	
	@FXML
	private TableView<Amortizacion> amortizacion;

	@FXML
	private TableColumn<Amortizacion,String> mesCOL;

	@FXML
	private TableColumn<Amortizacion,String> coutaCOL;

	@FXML
	private TableColumn<Amortizacion,String> amorCOL;

	@FXML
	private TableColumn<Amortizacion,String> interesCOL;

	@FXML
	private TableColumn<Amortizacion,String> balanceCOL;
	
	@FXML
    private JFXButton aceptar;

    @FXML
    private JFXButton rechazar;

	private ModelFactoryController mfc = ModelFactoryController.getInstance();

	private ObservableList<Amortizacion> observableListAmo= FXCollections.observableList(mfc.getListaAmortizacion());
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mesCOL.setCellValueFactory(new PropertyValueFactory<>("meses"));
		coutaCOL.setCellValueFactory(new PropertyValueFactory<>("couta"));
		amorCOL.setCellValueFactory(new PropertyValueFactory<>("amortizacion"));
		interesCOL.setCellValueFactory(new PropertyValueFactory<>("interes"));
		balanceCOL.setCellValueFactory(new PropertyValueFactory<>("balance"));
		amortizacion.setItems(observableListAmo);
	}

	@FXML
	void aceptarCredito() {
		mfc.respuestaSolicitud('0');
		Stage stage = (Stage) aceptar.getScene().getWindow();
	  	stage.close();
	}
	
	@FXML
    void rechazarCredito() {
		mfc.respuestaSolicitud('1');
		Stage stage = (Stage) rechazar.getScene().getWindow();
	  	stage.close();
    }	
}
