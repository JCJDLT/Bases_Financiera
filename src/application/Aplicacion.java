package application;
	
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.ModelFactoryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vistasController.AmortizacionController;
import vistasController.InicioAdminController;
import vistasController.LoginController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Aplicacion extends Application {
	
	private static Stage escenarioPrincipal;
	private ModelFactoryController modelFactoryController;
	
	@Override
	public void start(Stage primaryStage) {
		modelFactoryController = ModelFactoryController.getInstance();
		modelFactoryController.setMain(this);
		
		escenarioPrincipal = primaryStage;
		escenarioPrincipal.setTitle("UniBanco");
		mostrarVistaLogin();
	}
	
	public void mostrarVistaLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/vistas/login.fxml"));
			loader.setController(new LoginController());
			AnchorPane vistaIndex = (AnchorPane) loader.load();
			Scene scene = new Scene(vistaIndex);
			escenarioPrincipal.setScene(scene);
			escenarioPrincipal.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void abrirPaginaAdmin() {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/inicioAdmin.fxml"));
            loader.setController(new InicioAdminController());
            Parent root = loader.load();
            Scene scene = new Scene(root);
            escenarioPrincipal.setScene(scene);
            escenarioPrincipal.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void abrirPaginaSimulacion() {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/amortizacion.fxml"));
            loader.setController(new AmortizacionController());
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.initOwner(escenarioPrincipal);
            dialog.initModality(Modality.APPLICATION_MODAL); 
            dialog.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
