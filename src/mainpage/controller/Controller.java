package mainpage.controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import MemberInfo.main.MainInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import list.mainclass.MainClass;
import login.main.LoginAnotherMain;

public class Controller implements Initializable
{
	Parent root;
	
	@FXML
	public ImageView imageTop1;
	@FXML
	public ImageView imageTop2;
	@FXML
	public ImageView imageTop3; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		imageTop1.setImage(new Image(new File("src/image/background.jpg").toURI().toString()));
		imageTop2.setImage(new Image(new File("src/image/balt.jpg").toURI().toString()));
		imageTop3.setImage(new Image(new File("src/image/images.jpg").toURI().toString()));
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void goBasketPage()
	{
		basket.mainclass.MainClass ms = new basket.mainclass.MainClass();
		ms.basketPageOn(root);
	}
	
	public void goListPage()
	{
		MainClass ms = new MainClass();
		ms.listPageOn(root);
	}
	
	public void goLoginPage()
	{
		LoginAnotherMain lm = new LoginAnotherMain();
		lm.loginPageOn(root);
	}
	
	public void chkMyinfo()
	{
		MainInfo mi = new MainInfo();
		mi.modifyPageOn(root);
	}
	
}
