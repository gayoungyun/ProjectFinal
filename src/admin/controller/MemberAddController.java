package admin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import admin.service.AdminService;
import admin.service.AdminServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MemberAddController implements Initializable{
	@FXML TextField memberIdTF;
	@FXML PasswordField memberPasswordPF;
	@FXML TextField memberNameTF;
	@FXML TextField memberBirthTF;
	@FXML TextField memberTelTF;
	@FXML RadioButton memberGenderRB;
	@FXML TextField memberAddTF;
	
	TableView<MemberData> memberInfo;
	TableColumn<MemberData, Integer> memberNum;
	TableColumn<MemberData, String> memberId;
	TableColumn<MemberData, String> memberPassword;
	TableColumn<MemberData, String> memberName;
	TableColumn<MemberData, String> memberBirth;
	TableColumn<MemberData, String> memberTel;
	TableColumn<MemberData, Integer> memberGender;
	TableColumn<MemberData, String> memberAdd;
	private ObservableList<MemberData> memberList = FXCollections.observableArrayList();


	Parent root;
	
	AdminService as = new AdminServiceImpl();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		memberInfo= CommonFxData.memberInfo;
		memberNum= CommonFxData.memberNum;
		memberId = CommonFxData.memberId;
		memberPassword = CommonFxData.memberPassword;
		memberName = CommonFxData.memberName;
		memberBirth = CommonFxData.memberBirth;
		memberTel = CommonFxData.memberTel;
		memberGender = CommonFxData.memberGender;
		memberAdd = CommonFxData.memberAdd;
		
	}
	
	

	public void memberAddBtn() {
		setAddFxData();
		as.memberAddBtn();
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setAddFxData() {
		as.setAddFxData(memberIdTF, memberPasswordPF, memberNameTF, memberBirthTF, memberTelTF, memberGenderRB, memberAddTF);
		as.setCommonFxData(memberInfo, memberNum, memberId,
				memberPassword, memberName, memberBirth, memberTel, 
				memberGender, memberAdd);
	}
	


}












