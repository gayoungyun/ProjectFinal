package search.id.controller;

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

public class SearchIdController implements Initializable{
	@FXML public TextField searchIdName;
	@FXML public TextField searchIdNum;
	@FXML public PasswordField fxPwd;
	@FXML public Button btnCloseId;
	@FXML public Button btnSearch01;
	Parent root;

	
	public void setroot(Parent root) {
		this.root = root;
	}
	
	
	public void search_IdFunc () {
		System.out.println( "name : "+ searchIdName.getText() );
		System.out.println( "ph : "+ searchIdNum.getText());
		String name = searchIdName.getText();
		String ph = searchIdNum.getText();
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.search_IdFunc(name, ph);
	}
	public void cancelFunc1() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
}
