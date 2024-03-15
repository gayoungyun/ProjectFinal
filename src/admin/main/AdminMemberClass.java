package admin.main;

import java.net.URL;
import java.nio.file.Paths;

import admin.controller.MemberAddController;
import admin.controller.MemberAdminController;
import admin.controller.MemberChangeController;
import admin.dto.AdminDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminMemberClass{

	
	public void memberViewFx(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		try {
			URL url = new URL("file:/"+Paths.get("").toAbsolutePath().toString()+"/bin/admin/fxml/adminMemberManage.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			MemberAdminController apc = loader.getController();
			apc.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void memberAddFx() {
		Stage stage = new Stage();
		Parent root = null;
		try {
			URL url = new URL("file:/"+Paths.get("").toAbsolutePath().toString()+"/bin/admin/fxml/memberAdd.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			MemberAddController apc = loader.getController();
			apc.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void memberChangeFx(AdminDTO dto, Label testFx) {
		Stage stage = new Stage();
		Parent root = null;
		try {
			URL url = new URL("file:/"+Paths.get("").toAbsolutePath().toString()+"/bin/admin/fxml/memberChange.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			MemberChangeController ctrl = loader.getController();
			ctrl.setRoot(root, dto, testFx);
			ctrl.setInit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
