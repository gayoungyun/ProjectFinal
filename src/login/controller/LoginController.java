package login.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Member.main.MainClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.dao.LoginDAO;
import login.url.URLService;
import search.id.controller.SearchIdController;
import search.pwd.controller.SearchPwdController;


public class LoginController implements Initializable{
	@FXML public TextField fxId;
	@FXML public TextField fxName;
	@FXML public TextField fxPh;
	@FXML public PasswordField fxPwd;
	@FXML public Button btnLogin;
	@FXML public Button btnClose;
	@FXML public Button btnSearchId;
	@FXML public Button btnSearchPwd;
	@FXML public Button btnSignup;
	Parent root ;
	public void setroot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void loginFunc( ) {
		System.out.println("--- 서비스 로그인 확인 ---");
		System.out.println( "id : "+ fxId.getText() );
		System.out.println( "pwd : "+ fxPwd.getText());
		String id = fxId.getText();
		String pw = fxPwd.getText();
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.loginFunc(id, pw, root);
	}

	public void cancelFunc() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void searchIdFunc() {
		Stage searchidStage = new Stage();
		Parent root = null;
		try {
			URL url = new URL( URLService.fxPath + "login/main/SearchId.fxml" );
			System.out.println(URLService.fxPath + "login/main/SearchId.fxml");
			FXMLLoader loader = new FXMLLoader( url );
			root = loader.load();
			System.out.println(root);
			SearchIdController sctrl = loader.getController();
			sctrl.setroot(root);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Scene scene = new Scene(root);
		searchidStage.setScene(scene);
		searchidStage.show();
	}

	public void searchPwdFunc() {
		Stage searchpwdStage = new Stage();
		Parent root = null;
		try {
			URL url = new URL( URLService.fxPath + "login/main/SearchPwd.fxml" );
			FXMLLoader loader = new FXMLLoader( url );
			root = loader.load();
			System.out.println(root);
			SearchPwdController sctrl = loader.getController();
			sctrl.setroot(root);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Scene scene = new Scene(root);
		searchpwdStage.setScene(scene);
		searchpwdStage.show();
	}
	
	public void registerFunc() 
	{
		MainClass ms = new MainClass();
		ms.registerPageOn(root);
		
		
		
	}
}