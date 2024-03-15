package admin.controller;

import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import login.main.LoginAnotherMain;

public class MemberAdminController implements Initializable{
	@FXML TableView<MemberData> memberInfo;
	@FXML TableColumn<MemberData, Integer> memberNum;
	@FXML TableColumn<MemberData, String> memberId;
	@FXML TableColumn<MemberData, String> memberPassword;
	@FXML TableColumn<MemberData, String> memberName;
	@FXML TableColumn<MemberData, String> memberBirth;
	@FXML TableColumn<MemberData, String> memberTel;
	@FXML TableColumn<MemberData, Integer> memberGender;
	@FXML TableColumn<MemberData, String> memberAdd;
	@FXML Label testFx;
	@FXML TextField memberSearchTF;

	private ObservableList<MemberData> memberList = FXCollections.observableArrayList();
	AdminDTO dto;
	AdminDAO dao;
	AdminService as = new AdminServiceImpl();
	Parent root;
	
	ObservableList<String> imageArr;
	
	String path;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		CommonFxData.memberInfo = memberInfo;
		CommonFxData.memberNum = memberNum;
		CommonFxData.memberId = memberId;
		CommonFxData.memberPassword = memberPassword;
		CommonFxData.memberName = memberName;
		CommonFxData.memberBirth = memberBirth;
		CommonFxData.memberTel = memberTel;
		CommonFxData.memberGender = memberGender;
		CommonFxData.memberAdd = memberAdd;
		CommonFxData.memberList = memberList;
				
		refreshMemberTableView();
		
		TableView.TableViewSelectionModel<MemberData> selectionModel = memberInfo.getSelectionModel();
		selectionModel.selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	dto = new AdminDTO();
		    	dto.setMemberNum(newSelection.getY_num());
		    	dto.setMemberId(newSelection.getY_id());
		    	dto.setMemberPassword(newSelection.getY_pwd());
		    	dto.setMemberName(newSelection.getY_name());
		    	dto.setMemberBirth(newSelection.getY_brith());
		    	dto.setMemberTel(newSelection.getY_tel());
		    	dto.setMemberGender(newSelection.getY_gender());
		    	dto.setMemberAdd(newSelection.getY_add());
		    }
		});
		memberInfo.getSelectionModel().selectFirst();
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
	public void moveProductManegeFunc() {
		AdminProductClass apc = new AdminProductClass();
		apc.productViewFx(root);
	}
	public void moveMemberManageFunc() {
		AdminMemberClass amc = new AdminMemberClass();
		amc.memberViewFx(root);
	}
	
	public void memberDelete() {
		as.memberDelete(dto);
		int num = memberInfo.getSelectionModel().getSelectedIndex();
		System.out.println(num);
		if (num == 0) {
			dto = null;
		}
		refreshMemberTableView();
		memberInfo.getSelectionModel().selectFirst();
	}
	
	public void memberSearch() {
		setFxData();
		as.memberSearch();
		
	}
	public void refreshMemberTableView() {
		setFxData();
		as.refreshMemberTableView();
		memberSearchTF.clear();
	}
	
	public void refreshTableFunc() {
		refreshMemberTableView();
	}
	
	public void memberAdd() {
		AdminMemberClass amc = new AdminMemberClass();
		amc.memberAddFx();
	}
	
	public void memberChange() {
		as.memberChange(dto,testFx);
	}
	
	public void setFxData() {
		as.setFxData(memberInfo, memberNum, memberId, memberPassword, memberName, memberBirth, 
				memberTel, memberGender, memberAdd, memberSearchTF);
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
