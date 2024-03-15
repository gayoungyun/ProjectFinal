package search.pwd.controller;
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
public class SearchPwdController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	@FXML public TextField searchPwdId;
	@FXML public TextField searchPwdNum;
	@FXML public Button btnCloseId;
	@FXML public Button btnSearch01;
	Parent root;

	
	public void setroot(Parent root) {
		this.root = root;
	}
	
	
	public void search_PwdFunc () {
		System.out.println( "id : "+ searchPwdId.getText() );
		System.out.println( "ph : "+ searchPwdNum.getText());
		String id = searchPwdId.getText();
		String ph = searchPwdNum.getText();
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.search_PwdFunc(id, ph);
	}
	public void cancelFunc2() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
}
