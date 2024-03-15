package login.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controller.LoginController;
import login.dao.LoginDAO;
import search.id.controller.SearchIdController;

public class LoginMain extends Application{

	
	@Override 
	public void start(Stage arg0) throws Exception 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		arg0.setScene(scene);
		LoginController ctrl = loader.getController();
		ctrl.setroot(root);
		arg0.show();
	}
	public static void main(String[] args) {
		LoginController con = new LoginController();
		SearchIdController scon = new SearchIdController();
		LoginDAO dao = new LoginDAO();
		launch(args);
	}
}