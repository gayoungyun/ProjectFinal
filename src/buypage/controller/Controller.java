package buypage.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import list.listDTO.listDTO;
import buypage.buypageDAO.*;

public class Controller implements Initializable{

	Parent root;
	
//  구매페이지 FXML
	@FXML
	public Label productName;
	@FXML
	public Label productPrice;
	@FXML
	private ImageView productImage;
	
	// 구매 버튼 클릭시 사용될 변수들
	int userNumber;
	int proNumber;
	String proName;
	String proPrice;
	String category;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		
	}
	
	public void setRoot(Parent root) 
	{
		this.root = root;
	}
	
	public void getProductInformation(int userNumber, int proNumber, String proName, String proPrice, String url, String category)
	{
		System.out.println(proName);
		
		productName.setText(proName);
		productPrice.setText(proPrice);
		
		System.out.println(url);
		productImage.setImage(new Image(new File(url).toURI().toString()));
		
		this.userNumber = userNumber;
		this.proNumber = proNumber;
		this.proName = proName;
		this.proPrice = proPrice;
		this.category = category;
		
	}
	
	public void cancelFunc()
	{
		System.out.println("캔슬 출력");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	
	
	public void buyFunc()
	{
		BuyPageDAO dao = new BuyPageDAO();
		
		dao.setBill(userNumber, proNumber, proName, proPrice, category);
		
		
	}
	
	
}
