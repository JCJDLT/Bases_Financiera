package vistasController;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import controller.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField correo;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton entrar;
    @FXML
    private JFXButton crearCuenta;
    
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void iniciarSesion() {
    	//int bandera = mfc.validarLogin("jcjdlt@hotmail.com","123");
    	int bandera = mfc.validarLogin("emerson","123");
        if(bandera==3) {
        	abrirPaginaAdmin();
        }else {
        	JOptionPane.showMessageDialog( null, "Credenciales Invalidas" );
        }
    }

    @FXML
    private void crearCuenta() {
    }
    
    public void abrirPaginaAdmin(){
    	mfc.getMain().abrirPaginaAdmin();
    }
}
