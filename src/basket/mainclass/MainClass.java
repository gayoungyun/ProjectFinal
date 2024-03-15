package basket.mainclass;

import java.net.URL;
import java.nio.file.Paths;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass 
{
	public void basketPageOn(Parent root)
	{
		Stage memberStage = (Stage)root.getScene().getWindow();
		
		try
		{
			//fxPath : 현재 프로젝트 위치 + member...
			URL url = new URL("file:/" + (Paths.get("").toAbsolutePath().toString()) + "/bin/cart.fxml");
			System.out.println(url);
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			
			basket.controller.Controller ctrl = loader.getController();
			ctrl.setRoot(root);
			
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
