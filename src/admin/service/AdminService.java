package admin.service;

import admin.dto.AdminDTO;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface AdminService {
	
	public void logoutFunc();
	public void myPageFunc();
	public void noticeFunc();
	public void productShow(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCateColumn, String str);
	
	public void moveTopFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory);
	public void moveBottomFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory);
	public void moveAccFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory);
	public void moveShoeFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory);
	public void moveBagFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory);
	
	public void productDelete(AdminDTO dto);
	public void productAddBtn(TextField addProductNumber, TextField addProductName,
			TextField addProductPrice, TextField addProductImageRoot, MenuButton addProductCategoryMB, Parent root);
	public void productDataChangeBtn(Parent root, AdminDTO dto);
	public void productDataChange(AdminDTO dto);
	
	public void refreshTableView();
	public void setProductChangeFxData(TextField changeProductNumber, TextField changeProductName, 
			TextField changeProductPrice, TextField changeProductImageRoot, MenuButton changeProductCategoryMB);
	public void prodCommonFxData(TableView productInfo, TableColumn productNumber, TableColumn productName,
			TableColumn productPrice, TableColumn productCategory,TableColumn productImageRoot);
	public void setTableFxData(TableView productInfo, TableColumn productNumber, TableColumn productName,
			TableColumn productPrice, TableColumn productCategory,TableColumn productImageRoot);


// ----------------------------------------------------------------------------------------------
	
	
	public void memberDelete(AdminDTO dto);
	public void memberSearch();
	public void memberAddBtn();
	public void memberChange(AdminDTO dto, Label testFx);
	public void memberChangeBtn(Parent root, AdminDTO dto);
	public void refreshMemberTableView() ;
	public void setFxData(TableView memberInfo, TableColumn memberNum, TableColumn memberId,
			TableColumn memberPassword, TableColumn memberName, TableColumn memberBirth, TableColumn memberTel, 
			TableColumn memberGender, TableColumn memberAdd, TextField memberSearchTF);
	public void setAddFxData (TextField memberIdTF, PasswordField memberPasswordPF, TextField memberNameTF,
			TextField memberBirthTF, TextField memberTelTF, RadioButton memberGenderRB, TextField memberAddTF);
	public void setMemberChangeFxData(TextField changeMemberNum, TextField changeMemberId, PasswordField changeMemberPwd, 
			TextField changeMemberName, TextField changeMemberBirth, TextField changeMemberTel, 
			TextField changeMemberAdd, RadioButton changeMemberMan, RadioButton changeMemberWoman);
	public void setCommonFxData(TableView memberInfo, TableColumn memberNum, TableColumn memberId,
			TableColumn memberPassword, TableColumn memberName, TableColumn memberBirth, TableColumn memberTel, 
			TableColumn memberGender, TableColumn memberAdd);



}


