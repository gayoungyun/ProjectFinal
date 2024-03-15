package list.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MemberInfo.main.MainInfo;
import basket.basketDAO.BasketDAO;
import buypage.mainclass.MainClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import list.listDAO.listDAO;
import list.listDTO.listDTO;
import login.main.LoginAnotherMain;

public class Controller implements Initializable
{
	Parent root;
	listDAO dao;
	ArrayList<listDTO> list;
	
	int index;
	
	@FXML 
	private TableView<listDTO> itemList;
	@FXML
	private	TableColumn<listDTO, String> itemNum;
	@FXML
	private TableColumn<listDTO, String> itemName;
	@FXML
	private TableColumn<listDTO, String> itemPrice;
	
//	---------------------------------------------------------------
	
	@FXML
	private ImageView itemImage;
	
	@FXML
	ObservableList<listDTO> myList = FXCollections.observableArrayList();				

	public void setRoot(Parent root) 
	{
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		dao = new listDAO();
		list = dao.bringAllDB();
	
		
		for(listDTO e: list)
		{
			myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
		}
				
		itemNum.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
		itemName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		itemPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
		
		itemList.setItems(myList);
	}
	
	public void viewImage()
	{
		// list.get(index)
		// itemImage.setImage(new Image(getClass().getResource(list.get(index).getProductIamgeRoot()).toExternalForm()));
		index = itemList.getSelectionModel().getSelectedIndex();
		
		itemImage.setImage(new Image(new File(list.get(index).getProductIamgeRoot()).toURI().toString()));
	}
	
	public void buyBtnClick()
	{	
		System.out.println("구매 버튼 클릭");
		
		MainClass ms = new MainClass();
		
		ms.buyingPageOn(1 , list.get(index).getProductNumber() ,list.get(index).getProductName(), list.get(index).getProductPrice(), list.get(index).getProductIamgeRoot(), list.get(index).getProductCategory() );
		
	}
	
	public void basketBtnClick()
	{
		System.out.println("장바구니 버튼 클릭");
		
		listDTO dto = new listDTO(list.get(index).getProductNumber(), list.get(index).getProductName(), list.get(index).getProductPrice(), list.get(index).getProductIamgeRoot(), list.get(index).getProductCategory());
		
		// 나중에 유저 넘버 추가하기
		BasketDAO Bdao = new BasketDAO();
		
		Bdao.insertBaskeyProduct(dto, 1);
	}
	
	public void goBasketPage()
	{
		basket.mainclass.MainClass ms = new basket.mainclass.MainClass();
		ms.basketPageOn(root);
	}
	
	// 카테고리 상의 버튼 클릭
	public void sortCategoryZero()
	{
		myList.clear();
	
		for(listDTO e: list)
		{
			myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
		}
	}
	
	// 카테고리 상의 버튼 클릭
	public void sortCategoryOne()
	{
		myList.clear();
	
		for(listDTO e: list)
		{
			if(e.getProductCategory().equals("상의"))
				myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
		}
	}
	
	// 카테고리 하의 버튼 클릭
	public void sortCategoryTwo()
	{
		myList.clear();
		
		for(listDTO e: list)
		{
			if(e.getProductCategory().equals("하의"))
				myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
		}
	}
	
		// 카테고리 악세서리 버튼 클릭
		public void sortCategoryThree()
		{
			myList.clear();
			
			for(listDTO e: list)
			{
				if(e.getProductCategory().equals("악세서리"))
					myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
			}
		}
		
		// 카테고리 신발 클릭
		public void sortCategoryFour()
		{
			myList.clear();
			
			for(listDTO e: list)
			{
				if(e.getProductCategory().equals("신발"))
					myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
			}
		}
		
		// 카테고리 가방 클릭
		public void sortCategoryFive()
		{
			myList.clear();
			
			for(listDTO e: list)
			{
				if(e.getProductCategory().equals("가방"))
					myList.add(new listDTO(e.getProductNumber(), e.getProductName(), e.getProductPrice(), e.getProductIamgeRoot(), e.getProductCategory()));
			}
		}
		
		public void gotoMain()
		{
			mainpage.mainclass.MainClass ms = new mainpage.mainclass.MainClass(); 
			
			ms.mainPageOn(root);
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
