package Member.main;

import java.net.URL;
import java.nio.file.Paths;

import Member.controller.MemberController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import register.url.URLService;

public class MainClass {
	
	public void registerPageOn(Parent root)
	{
		Stage memberStage = (Stage)root.getScene().getWindow();
		
		try
		{
			//fxPath : 현재 프로젝트 위치 + member...
			URL url= new URL(URLService.fxPath+"register.fxml");
			System.out.println(url);
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			
			MemberController ctrl = loader.getController();
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


