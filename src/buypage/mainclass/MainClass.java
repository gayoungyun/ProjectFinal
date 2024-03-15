package buypage.mainclass;

import java.net.URL;
import java.nio.file.Paths;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass {
	
	public void buyingPageOn(int userNumber, int proNumber, String proName, String proPrice, String u, String Category)
	{
		Stage memberStage = new Stage();
		Parent root = null;
		
		
		
		
		try
		{
			//fxPath : 현재 프로젝트 위치 + member...
			URL url = new URL("file:/" + (Paths.get("").toAbsolutePath().toString()) + "/bin/buypage.fxml");
			System.out.println(url);
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			
			buypage.controller.Controller ctrl = loader.getController();
			ctrl.setRoot(root);
			
			ctrl.getProductInformation(userNumber, proNumber, proName, proPrice, u, Category);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		memberStage.setScene(scene);
		memberStage.show();
		
	}
}