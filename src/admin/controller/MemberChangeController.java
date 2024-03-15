package admin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import admin.dto.AdminDTO;
import admin.service.AdminService;
import admin.service.AdminServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MemberChangeController implements Initializable{
	@FXML TextField changeMemberNum;
	@FXML TextField changeMemberId;
	@FXML PasswordField changeMemberPwd;
	@FXML TextField changeMemberName;
	@FXML TextField changeMemberBirth;
	@FXML TextField changeMemberTel;
	@FXML TextField changeMemberAdd;
	@FXML RadioButton changeMemberMan;
	@FXML RadioButton changeMemberWoman;
	
	TableView<MemberData> memberInfo;
	TableColumn<MemberData, Integer> memberNum;
	TableColumn<MemberData, String> memberId;
	TableColumn<MemberData, String> memberPassword;
	TableColumn<MemberData, String> memberName;
	TableColumn<MemberData, String> memberBirth;
	TableColumn<MemberData, String> memberTel;
	TableColumn<MemberData, Integer> memberGender;
	TableColumn<MemberData, String> memberAdd;
	
	AdminService as = new AdminServiceImpl();
	
	Parent root;
	AdminDTO dto;
	Label testFx;
	
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
	
	public void setRoot(Parent root, AdminDTO dto, Label testFx) {
		this.root = root;
		this.dto = dto;
		this.testFx = testFx;
		System.out.println("testfx : " + testFx);
	}
	public void memberChangeBtn() {
		setMemberChangeFxData();
		setCommonFxData();
		as.memberChangeBtn(root, dto);
	}
	
	public void setMemberChangeFxData() {
		as.setMemberChangeFxData(changeMemberNum, changeMemberId, changeMemberPwd, changeMemberName, 
				changeMemberBirth, changeMemberTel, changeMemberAdd, changeMemberMan, changeMemberWoman);
	}
	
	public void setCommonFxData() {
		as.setCommonFxData(memberInfo, memberNum, memberId,
				memberPassword, memberName, memberBirth, memberTel, 
				memberGender, memberAdd);
	}
	
	public void setInit() {
		changeMemberNum.setText(Integer.toString(dto.getMemberNum()));
		changeMemberId.setText(dto.getMemberId());
		changeMemberPwd.setText(dto.getMemberPassword());
		changeMemberName.setText(dto.getMemberName());
		changeMemberBirth.setText(dto.getMemberBirth());
		changeMemberTel.setText(dto.getMemberTel());
		changeMemberAdd.setText(dto.getMemberAdd());
		if (dto.getMemberGender() == 0) {
			changeMemberMan.setSelected(true);
		} else {
			changeMemberWoman.setSelected(true);
		}
	}



}












