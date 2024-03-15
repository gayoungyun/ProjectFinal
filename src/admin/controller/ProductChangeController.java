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
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductChangeController implements Initializable{
	@FXML TextField changeProductNumber;
	@FXML TextField changeProductName;
	@FXML TextField changeProductPrice;
	@FXML TextField changeProductImageRoot;
	@FXML TextField changeProductCategory;
	@FXML MenuButton changeProductCategoryMB ;
	MenuItem menuItem;
	Parent root;
	AdminDTO dto;
	AdminService as = new AdminServiceImpl();
	
	TableView<ProductTableData> productInfo;
	TableColumn<ProductTableData, Integer> productNumber;
	TableColumn<ProductTableData, String> productName;
	TableColumn<ProductTableData, String> productPrice;
	TableColumn<ProductTableData, String> productCategory;
	TableColumn<ProductTableData, String> productImageRoot;
	
	
	public void setRoot(Parent root, AdminDTO dto) {
		this.root = root;
		this.dto = dto;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		productInfo = CommonFxData.productInfo;
		productNumber = CommonFxData.productNumber;
		productName = CommonFxData.productName;
		productPrice = CommonFxData.productPrice;
		productCategory = CommonFxData.productCategory;
		productImageRoot = CommonFxData.productImageRoot;
	}
	
	public void productDataChangeBtn() {
		setProductChangeFxData();
		as.productDataChangeBtn(root, dto);
	}
	
	public void setInit() {
		changeProductNumber.setText(Integer.toString(dto.getProductNumber()));
		changeProductName.setText(dto.getProductName());
		changeProductPrice.setText(dto.getProductPrice());
		changeProductImageRoot.setText(dto.getProductImageRoot());
		changeProductCategoryMB.setText(dto.getProductCategory());
	}
	
	public void setProductChangeFxData() {
		as.setProductChangeFxData(changeProductNumber, changeProductName, changeProductPrice, 
				changeProductImageRoot, changeProductCategoryMB);
		as.prodCommonFxData(productInfo, productNumber, productName, productPrice, 
				productCategory, productImageRoot);
	}
	
	public void itemClickMI(ActionEvent event) {
		menuItem = (MenuItem) event.getSource();
		changeProductCategoryMB.setText(menuItem.getText());
	}
	
	
}
