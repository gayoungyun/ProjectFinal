package login.main;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controller.LoginController;

public class LoginAnotherMain 
{
	public void loginPageOn(Parent root)
	{
		Stage memberStage = (Stage)root.getScene().getWindow();
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			root = loader.load();
			
			LoginController ctrl = loader.getController();
			ctrl.setroot(root);
				
			Scene scene = new Scene(root);
			memberStage.setScene(scene);
			memberStage.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
