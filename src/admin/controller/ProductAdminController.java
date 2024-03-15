package admin.controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import MemberInfo.main.MainInfo;
import admin.dao.AdminDAO;
import admin.dto.AdminDTO;
import admin.main.AdminMemberClass;
import admin.main.AdminProductClass;
import admin.service.AdminService;
import admin.service.AdminServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import login.main.LoginAnotherMain;

public class ProductAdminController implements Initializable{
	@FXML TableView<ProductTableData> productInfo;
	@FXML TableColumn<ProductTableData, Integer> productNumber;
	@FXML TableColumn<ProductTableData, String> productName;
	@FXML TableColumn<ProductTableData, String> productPrice;
	@FXML TableColumn<ProductTableData, String> productCategory;
	@FXML TableColumn<ProductTableData, String> productImageRoot;
	@FXML ImageView imageView;

	private ObservableList<ProductTableData> dataList = FXCollections.observableArrayList();
	AdminDTO dto;
	AdminDAO dao;
	AdminService as = new AdminServiceImpl();
	AdminProductClass apc;
	AdminMemberClass amc;
	Parent root;
	
	ObservableList<String> imageArr;
	
	String path;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CommonFxData.productInfo = productInfo;
		CommonFxData.productNumber = productNumber;
		CommonFxData.productName = productName;
		CommonFxData.productPrice = productPrice;
		CommonFxData.productCategory = productCategory;
		CommonFxData.productImageRoot = productImageRoot;
		
		refreshFunc();
		TableView.TableViewSelectionModel<ProductTableData> selectionModel = productInfo.getSelectionModel();
		selectionModel.selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	dto = new AdminDTO();
		    	dto.setProductNumber(newSelection.getNumber());
		    	dto.setProductName(newSelection.getName());
		    	dto.setProductPrice(newSelection.getPrice());
		    	dto.setProductImageRoot(newSelection.getImageRoot());
		    	dto.setProductCategory(newSelection.getCategory());
		    	System.out.println("선택한 행의 number : " + dto.getProductNumber());
		    	imageView();
		    }
		});
		productInfo.getSelectionModel().selectFirst();
	}
	
	public void logoutFunc() {
		as.logoutFunc();
	}
	public void myPageFunc() {
		as.myPageFunc();
	}
	public void noticeFunc() {
		as.noticeFunc();
	}
	public void moveTopFunc() {
		as.moveTopFunc(productInfo, productNumber, productName, productPrice, productCategory);
	}
	public void moveBottomFunc() {
		as.moveBottomFunc(productInfo, productNumber, productName, productPrice, productCategory);
	}
	public void moveAccFunc() {
		as.moveAccFunc(productInfo, productNumber, productName, productPrice, productCategory);
	}
	public void moveShoeFunc() {
		as.moveShoeFunc(productInfo, productNumber, productName, productPrice, productCategory);
	}
	public void moveBagFunc() {
		as.moveBagFunc(productInfo, productNumber, productName, productPrice, productCategory);
	}
	public void moveAllFunc() {
		refreshFunc();
	}
	public void productDelete() {
		as.productDelete(dto);
		int num = productInfo.getSelectionModel().getSelectedIndex();
		System.out.println(num);
		if (num == 0) {
			dto = null;
			imageView.setImage(null);
		}
		refreshFunc();
		productInfo.getSelectionModel().selectFirst();
		
	}
	public void productAdd() {
		apc = new AdminProductClass();
		apc.productAddView();
	}
	public void moveProductManegeFunc() {
		apc = new AdminProductClass();
		apc.productViewFx(root);
	}
	public void moveMemberManageFunc() {
		amc = new AdminMemberClass();
		amc.memberViewFx(root);
	}
	
	public void refreshFunc() {
		setTableFxData();
		as.refreshTableView();
	}
	
	public void productDataChange() {
		as.productDataChange(dto);
	}
	
	public void imageView() {
		AdminDAO dao = new AdminDAO();
		String imageRoot = dao.setImageView(dto);
		path = Paths.get("").toAbsolutePath().toString();
		path += "/src/admin/source/"+imageRoot;
		File file = new File(path);
		System.out.println("file : " + file.toURI().toString());
		Image img = new Image(file.toURI().toString());
		imageView.setImage(img);
	}
	
	public void setTableFxData() {
		as.setTableFxData(productInfo, productNumber, productName, productPrice, 
				productCategory, productImageRoot);
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
