package basket.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MemberInfo.main.MainInfo;
import basket.basketDAO.BasketDAO;
import basket.basketDTO.BasketDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import login.main.LoginAnotherMain;
import mainpage.mainclass.MainClass;

public class Controller implements Initializable{
	
	Parent root;
	
	ArrayList<BasketDTO> list;
	BasketDAO dao;
	
	@FXML
	public CheckBox check1;
	@FXML
	public CheckBox check2;
	@FXML
	public CheckBox check3;
	@FXML
	public CheckBox check4;
	@FXML
	public CheckBox check5;
	@FXML
	public CheckBox check6;
	@FXML
	public CheckBox check7;
	
	@FXML
	public Label totalPrice;
	
	@FXML
	public TableView<BasketDTO> itemList;
	@FXML
	public TableColumn<BasketDTO, String> itemNum;
	@FXML
	public TableColumn<BasketDTO, String> itemName;
	@FXML
	public TableColumn<BasketDTO, String> itemPrice;
	
	@FXML
	ObservableList<BasketDTO> myList = FXCollections.observableArrayList();	
	
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		dao = new BasketDAO();
		
		setBasketList();
	}
	
	public void setBasketList()
	{
		myList.clear();
		
		list = dao.bringBaskeyDB(1);
		
		for(BasketDTO e: list)
		{
			myList.add(new BasketDTO(e.getUserNumber(), e.getProductNumber(), e.getProductListNumber(),e.getProductName(), e.getProductPrice(), e.getProductImageRoot(), e.getProductCategory()));
		}
				
		itemNum.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
		itemName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		itemPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
		
		itemList.setItems(myList);
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void cartBtn1()
	{
		check1 = (CheckBox)root.lookup("#check1");
		
		if(check1.isSelected())
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(0).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(0).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	
	public void cartBtn2()
	{
		check2 = (CheckBox)root.lookup("#check2");
		
		if(check2.isSelected())
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(1).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(1).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	
	public void cartBtn3()
	{
		check3 = (CheckBox)root.lookup("#check3");
		
		if(check3.isSelected())
		{
			
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(2).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(2).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	
	public void cartBtn4()
	{
		check4 = (CheckBox)root.lookup("#check4");
		
		if(check4.isSelected())
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(3).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(3).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	
	public void cartBtn5()
	{
		check5 = (CheckBox)root.lookup("#check5");
		
		if(check5.isSelected())
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(4).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(4).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	public void cartBtn6()
	{
		check6 = (CheckBox)root.lookup("#check6");
		
		if(check6.isSelected())
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(5).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(5).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	public void cartBtn7()
	{
		check7 = (CheckBox)root.lookup("#check7");
		
		if(check7.isSelected())
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(6).getProductPrice());
			
			int temp = nowPrice + selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
		else
		{
			int nowPrice = Integer.parseInt(totalPrice.getText());
			int selectPrice = Integer.parseInt(list.get(6).getProductPrice());
			
			int temp = nowPrice - selectPrice;
			
			totalPrice.setText(String.valueOf(temp));
		}
	}
	
	public void cancelBasket()
	{
		if(check1.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(0).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(0).getProductListNumber());
			check1.setSelected(false);
		}
		if(check2.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(1).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(1).getProductListNumber());
			check2.setSelected(false);
		}
		if(check3.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(2).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(2).getProductListNumber());
			check3.setSelected(false);
		}
		if(check4.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(3).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(3).getProductListNumber());
			check4.setSelected(false);
		}
		if(check5.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(4).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(4).getProductListNumber());
			check5.setSelected(false);
		}
		if(check6.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(5).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(5).getProductListNumber());
			check6.setSelected(false);
		}
		if(check7.isSelected())
		{
			int temp = Integer.parseInt(totalPrice.getText()) - Integer.parseInt(list.get(6).getProductPrice());
			totalPrice.setText(String.valueOf(temp));
			dao.deleteBasketProduct(list.get(6).getProductListNumber());
			check7.setSelected(false);
		}
		
		setBasketList();
	}
	
	public void buybtn()
	{
		 Alert alert = new Alert(AlertType.INFORMATION);
		 
		 alert.setContentText("구매가 완료되었습니다!!");
		 alert.show();
		
		 
		 // 나중에 맨앞 매게변수 유저 넘버 받아와서 넣기
			if(check1.isSelected())
			{
				dao.setBill(1, list.get(0).getProductListNumber(), list.get(0).getProductName(), list.get(0).getProductPrice(), list.get(0).getProductCategory());
			}
			if(check2.isSelected())
			{
				dao.setBill(1, list.get(1).getProductListNumber(), list.get(1).getProductName(), list.get(1).getProductPrice(), list.get(1).getProductCategory());
			}
			if(check3.isSelected())
			{
				dao.setBill(1, list.get(2).getProductListNumber(), list.get(2).getProductName(), list.get(2).getProductPrice(), list.get(2).getProductCategory());
			}
			if(check4.isSelected())
			{
				dao.setBill(1, list.get(3).getProductListNumber(), list.get(3).getProductName(), list.get(3).getProductPrice(), list.get(3).getProductCategory());
			}
			if(check5.isSelected())
			{
				dao.setBill(1, list.get(4).getProductListNumber(), list.get(4).getProductName(), list.get(4).getProductPrice(), list.get(4).getProductCategory());
			}
			if(check6.isSelected())
			{
				dao.setBill(1, list.get(5).getProductListNumber(), list.get(5).getProductName(), list.get(5).getProductPrice(), list.get(5).getProductCategory());
			}
			if(check7.isSelected())
			{
				dao.setBill(1, list.get(6).getProductListNumber(), list.get(6).getProductName(), list.get(6).getProductPrice(), list.get(6).getProductCategory());
			}
		 
			cancelBasket();
			
			
	}
	
	public void gotoMain()
	{
		MainClass ms = new MainClass();
		
		ms.mainPageOn(root);
	}
	
	public void goListPage()
	{
		list.mainclass.MainClass ms = new list.mainclass.MainClass();
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
