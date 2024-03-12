package login.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.dao.LoginDAO;
import login.url.URLService;


public class LoginController implements Initializable{
	@FXML public TextField fxId;
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
		loginDAO.loginFunc(id, pw);
	}

	public void cancelFunc() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void searchIdFunc() {
		Stage memberStage = new Stage();
		Parent root = null;
		try {
			URL url = new URL( URLService.fxPath + "login/main/SearchId.fxml" );
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void searchClose() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void searchPwdFunc() {}
	public void registerFunc() {}
}