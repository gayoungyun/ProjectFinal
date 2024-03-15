package admin.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CommonFxData {
	public static TableView<MemberData> memberInfo;
	public static TableColumn<MemberData, Integer> memberNum;
	public static TableColumn<MemberData, String> memberId;
	public static TableColumn<MemberData, String> memberPassword;
	public static TableColumn<MemberData, String> memberName;
	public static TableColumn<MemberData, String> memberBirth;
	public static TableColumn<MemberData, String> memberTel;
	public static TableColumn<MemberData, Integer> memberGender;
	public static TableColumn<MemberData, String> memberAdd;
	public static ObservableList<MemberData> memberList;
	
	
	
	
	public static TextField changeMemberNum;
	public static TextField changeMemberId;
	public static PasswordField changeMemberPwd;
	public static TextField changeMemberName;
	public static TextField changeMemberBirth;
	public static TextField changeMemberTel;
	public static TextField changeMemberAdd;
	public static RadioButton changeMemberMan;
	public static RadioButton changeMemberWoman;
	
	
	
	public static TableView<ProductTableData> productInfo;
	public static TableColumn<ProductTableData, Integer> productNumber;
	public static TableColumn<ProductTableData, String> productName;
	public static TableColumn<ProductTableData, String> productPrice;
	public static TableColumn<ProductTableData, String> productCategory;
	public static TableColumn<ProductTableData, String> productImageRoot;
}
