package admin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import admin.dao.AdminDAO;
import admin.dto.AdminDTO;
import admin.service.AdminService;
import admin.service.AdminServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductAddController implements Initializable{
	@FXML TextField addProductNumber;
	@FXML TextField addProductName;
	@FXML TextField addProductPrice;
	@FXML TextField addProductImageRoot;
	@FXML MenuButton addProductCategoryMB ;
	MenuItem menuItem;
	AdminService as = new AdminServiceImpl();
	Parent root;
	
	TableView<ProductTableData> productInfo;
	TableColumn<ProductTableData, Integer> productNumber;
	TableColumn<ProductTableData, String> productName;
	TableColumn<ProductTableData, String> productPrice;
	TableColumn<ProductTableData, String> productCategory;
	TableColumn<ProductTableData, String> productImageRoot;
	
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AdminDAO dao = new AdminDAO();
		addProductNumber.setText(Integer.toString(dao.searchProdNumber()));
		productInfo = CommonFxData.productInfo;
		productNumber = CommonFxData.productNumber;
		productName = CommonFxData.productName;
		productPrice = CommonFxData.productPrice;
		productCategory = CommonFxData.productCategory;
		productImageRoot = CommonFxData.productImageRoot;
		
	}
	public void productAddBtn() {
		prodCommonFxData();
		as.productAddBtn(addProductNumber, addProductName, addProductPrice, addProductImageRoot, addProductCategoryMB, root);
		
	}
	
	public void prodCommonFxData() {
		as.prodCommonFxData(productInfo, productNumber, productName, productPrice, 
				productCategory, productImageRoot);
	}

	public void itemClick(ActionEvent event) {
		menuItem = (MenuItem) event.getSource();
		addProductCategoryMB.setText(menuItem.getText());
	}
	

	
	

}
