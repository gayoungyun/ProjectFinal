package admin.service;

import java.util.ArrayList;
import java.util.Optional;

import admin.controller.MemberData;
import admin.controller.ProductTableData;
import admin.dao.AdminDAO;
import admin.dto.AdminDTO;
import admin.main.AdminMemberClass;
import admin.main.AdminProductClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminServiceImpl implements AdminService{
	
	TableView<ProductTableData> productInfo;
	TableColumn<ProductTableData, Integer> productNumber;
	TableColumn<ProductTableData, String> productName;
	TableColumn<ProductTableData, String> productPrice;
	TableColumn<ProductTableData, String> productCategory;
	TableColumn<ProductTableData, String> productImageRoot;
	MenuButton changeProductCategoryMB ;
	ImageView imageView;
	
	TextField changeProductNumber;
	TextField changeProductName;
	TextField changeProductPrice;
	TextField changeProductImageRoot;
	TextField changeProductCategory;
	
	TextField addProductNumber;
	TextField addProductName;
	TextField addProductPrice;
	TextField addProductImageRoot;
	TextField addProductCategory;
	
	private ObservableList<ProductTableData> dataList = FXCollections.observableArrayList();
	
	
	
	TableView<MemberData> memberInfo;
	TableColumn<MemberData, Integer> memberNum;
	TableColumn<MemberData, String> memberId;
	TableColumn<MemberData, String> memberPassword;
	TableColumn<MemberData, String> memberName;
	TableColumn<MemberData, String> memberBirth;
	TableColumn<MemberData, String> memberTel;
	TableColumn<MemberData, String> memberGender;
	TableColumn<MemberData, String> memberAdd;
	TextField memberSearchTF;
	
	TextField memberIdTF;
	PasswordField memberPasswordPF;
	TextField memberNameTF;
	TextField memberBirthTF;
	TextField memberTelTF;
	RadioButton memberGenderRB;
	TextField memberAddTF;
	
	TextField changeMemberNum;
	TextField changeMemberId;
	TextField changeMemberPwd;
	TextField changeMemberName;
	TextField changeMemberBirth;
	TextField changeMemberTel;
	TextField changeMemberAdd;
	RadioButton changeMemberMan;
	RadioButton changeMemberWoman;
	
	private ObservableList<MemberData> memberList = FXCollections.observableArrayList();



	@Override
	public void logoutFunc() {

	}

	@Override
	public void myPageFunc() {

	}

	@Override
	public void noticeFunc() {

	}
	
	
	// ------------------------------------ 공통 영역 ------------------------------------------------
	
	

	@Override
	public void moveTopFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory) {
		productShow(productInfo, productNumber, productName, productPrice, productCategory, "상의");
	}

	@Override
	public void moveBottomFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory) {
		productShow(productInfo, productNumber, productName, productPrice, productCategory, "하의");

	}

	@Override
	public void moveAccFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory) {
		productShow(productInfo, productNumber, productName, productPrice, productCategory, "악세사리");

	}

	@Override
	public void moveShoeFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory) {
		productShow(productInfo, productNumber, productName, productPrice, productCategory, "신발");

	}

	@Override
	public void moveBagFunc(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCategory) {
		productShow(productInfo, productNumber, productName, productPrice, productCategory, "가방");

	}

	public void productShow(TableView productInfo, TableColumn productNumber, TableColumn productName, TableColumn productPrice, TableColumn productCateColumn, String str) {
		dataList.removeAll(dataList);
		AdminDAO dao = new AdminDAO();
		ArrayList<AdminDTO> adminDTO = dao.getProduct(str);
		for (int i = 0; i < adminDTO.size(); i++) {
			AdminDTO dto = adminDTO.get(i);
			dataList.add(new ProductTableData(dto.getProductNumber(), dto.getProductName(), dto.getProductPrice(), dto.getProductImageRoot(), dto.getProductCategory()));			
		}
		productNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

		productInfo.setItems(dataList);
	}
	
	@Override
	public void productDelete(AdminDTO dto) {
		AdminDAO dao = new AdminDAO();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		Alert alert1 = new Alert(AlertType.INFORMATION);
		alert1.setTitle("상품 삭제");
		alert.setTitle("상품 삭제");
		if (dto == null) {
			alert1.setHeaderText("삭제하실 상품을 선택해주세요");
			alert1.show();
		} else {
			alert.setHeaderText("상품 정보를 삭제하시겠습니까?");
			alert.setContentText("확인을 클릭하시면 상품이 삭제됩니다.");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get().equals(ButtonType.OK)) {
				int num = dao.productDelete(dto);
				if (num == 1) {
					alert1.setHeaderText("삭제되었습니다.");
				} else {
					alert1.setHeaderText("문제가 발생했습니다.");
				}
				alert1.show();

			} else {
				alert.close();
			}
		}
	}

	
	public void productDataChange(AdminDTO dto) {
		if (dto == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("선택");
			alert.setHeaderText("변경을 원하는 상품을 선택해주세요");
			alert.show();
			
		} else {
			AdminProductClass apc = new AdminProductClass();
			System.out.println(dto.getProductName());
			apc.productChangeView(dto);
		}
	}
	
	public void productDataChangeBtn(Parent root, AdminDTO dto) {
		AdminDAO dao = new AdminDAO();
		System.out.println("변경 버튼 클릭");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("상품 변경");
		int num = productInfo.getSelectionModel().getSelectedIndex();
		System.out.println(changeProductName.getText());
		if (changeProductName.getText().equals(dto.getProductName())
				&& changeProductPrice.getText().equals(dto.getProductPrice())
				&& changeProductImageRoot.getText().equals(dto.getProductImageRoot())
				&& changeProductCategoryMB.getText().equals(dto.getProductCategory()) ) {
			alert.setHeaderText("내용을 변경해주세요");
			alert.show();
		} else {
			dto.setProductNumber(Integer.parseInt(changeProductNumber.getText()));
			dto.setProductName(changeProductName.getText());
			dto.setProductPrice(changeProductPrice.getText());
			dto.setProductImageRoot(changeProductImageRoot.getText());
			dto.setProductCategory(changeProductCategoryMB.getText());
			int result = dao.productChangBtn(dto);
			if (result == 1) {
				alert.setHeaderText("내용이 변경되었습니다.");
				alert.showAndWait();
				Stage stage = (Stage)root.getScene().getWindow();
				stage.close();
			} else {
				alert.setHeaderText("문제가 발생하였습니다. 값을 다시 입력해주세요");
				alert.show();
			}
		}
		refreshTableView();
		productInfo.getSelectionModel().select(num);
	}
	
	public void refreshTableView() {
		dataList.removeAll(dataList);
		AdminDAO dao = new AdminDAO();
		ArrayList<AdminDTO> adminDTO = dao.getProduct();
		for (int i = 0; i < adminDTO.size(); i++) {
			AdminDTO dto = adminDTO.get(i);
			dataList.add(new ProductTableData(dto.getProductNumber(), dto.getProductName(), dto.getProductPrice(), dto.getProductImageRoot(), dto.getProductCategory()));			
		}
		productNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		productCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		productImageRoot.setCellValueFactory(new PropertyValueFactory<>("imageRoot"));
		
		productInfo.setItems(dataList);
	}
	
	public void productAddBtn(TextField addProductNumber, TextField addProductName,
			TextField addProductPrice, TextField addProductImageRoot, MenuButton addProductCategoryMB, Parent root) {
		
		AdminDTO dto = new AdminDTO();
		AdminDAO dao = new AdminDAO();
		dto.setProductNumber(Integer.parseInt(addProductNumber.getText()));
		dto.setProductName(addProductName.getText());
		dto.setProductPrice(addProductPrice.getText());
		dto.setProductImageRoot(addProductImageRoot.getText());
		dto.setProductCategory(addProductCategoryMB.getText());
		Alert alert;
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("상품 추가");
		String msg;
		int result = dao.productAdd(dto);
		if (result == 1) {
			msg = "상품 추가 완료";
			alert.setHeaderText(msg);
			alert.showAndWait();
			addProductNumber.setText(Integer.toString(dao.searchProdNumber()));;
			addProductName.clear();
			addProductPrice.clear();
			addProductImageRoot.clear();
			addProductCategoryMB.setText("상의");
		} else {
			msg = "상품 추가 실패";
			alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(msg);
			alert.show();
		}
		refreshTableView();
		
	}
	
	public void setProductChangeFxData(TextField changeProductNumber, TextField changeProductName, 
			TextField changeProductPrice, TextField changeProductImageRoot, MenuButton changeProductCategoryMB) {
		this.changeProductNumber = changeProductNumber;
		this.changeProductName=changeProductName;
		this.changeProductPrice=changeProductPrice;
		this.changeProductImageRoot=changeProductImageRoot;
		this.changeProductCategoryMB=changeProductCategoryMB;
		
	}
	
	public void prodCommonFxData(TableView productInfo, TableColumn productNumber, TableColumn productName,
			TableColumn productPrice, TableColumn productCategory,TableColumn productImageRoot) {
		this.productInfo = productInfo;
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productImageRoot = productImageRoot;
		
	}
	
	public void setTableFxData(TableView productInfo, TableColumn productNumber, TableColumn productName,
			TableColumn productPrice, TableColumn productCategory,TableColumn productImageRoot) {
		this.productInfo = productInfo;
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productImageRoot = productImageRoot;
	}
	
	
	
	
	
	//------------------------------------------ product 영역 ----------------------------------------
	
	
	
	
	
	
	
	
	
	
	public void memberDelete(AdminDTO dto) {
		AdminDAO dao = new AdminDAO();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		Alert alert1 = new Alert(AlertType.INFORMATION);
		alert.setTitle("회원 삭제");
		alert1.setTitle("회원 삭제");
		
		if (dto == null) {
			alert1.setHeaderText("삭제를 원하는 회원을 선택해주세요");
			alert1.show();
		} else {
			alert.setHeaderText("회원 정보를 삭제하시겠습니까?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get().equals(ButtonType.OK)) {
				int num = dao.memberDelete(dto);
				if (num == 1) {
					alert1.setHeaderText("삭제가 완료되었습니다.");
				} else {
					alert1 = new Alert(AlertType.ERROR);
					alert1.setTitle("회원 삭제");
					alert1.setHeaderText("문제가 발생하였습니다.");
				}
				alert1.show();
			} else {
				alert.close();
			}
		}
		
	}
	
	public void memberSearch() {
		ArrayList<AdminDTO> dtoList = new ArrayList<>();
		AdminDAO dao = new AdminDAO();
		if (memberSearchTF.getText() == "") {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("회원 검색");
			alert.setHeaderText("검색할 회원의 아이디을 입력하세요");
			alert.show();
		} else {
			String id = memberSearchTF.getText();
			dtoList = dao.memberSearch(id);
			memberList.removeAll(memberList);
			for (int i = 0; i < dtoList.size(); i++ ) {
				AdminDTO dto = dtoList.get(i);
				if (dto != null) {
					memberList.add(new MemberData(dto.getMemberNum(),dto.getMemberId(), dto.getMemberPassword(), dto.getMemberName(),dto.getMemberBirth(),dto.getMemberTel(),dto.getMemberGender(),dto.getMemberAdd()));
					memberNum.setCellValueFactory(new PropertyValueFactory<>("y_num"));
					memberId.setCellValueFactory(new PropertyValueFactory<>("y_id"));
					memberPassword.setCellValueFactory(new PropertyValueFactory<>("y_pwd"));
					memberName.setCellValueFactory(new PropertyValueFactory<>("y_name"));
					memberBirth.setCellValueFactory(new PropertyValueFactory<>("y_brith"));
					memberTel.setCellValueFactory(new PropertyValueFactory<>("y_tel"));
					memberGender.setCellValueFactory(new PropertyValueFactory<>("y_gender"));
					memberAdd.setCellValueFactory(new PropertyValueFactory<>("y_add"));
					memberInfo.setItems(memberList);
				} else {
					System.out.println("해당하는 아이디의 사용자가 없음");
				}
			}
		}
		memberSearchTF.clear();
	}
	
	public void memberAddBtn () {
		AdminDTO dto = new AdminDTO();
		AdminDAO dao = new AdminDAO();
		int num;
		dto.setMemberNum(dao.searchMemNumber());
		dto.setMemberId(memberIdTF.getText());
		dto.setMemberPassword(memberPasswordPF.getText());
		dto.setMemberName(memberNameTF.getText());
		dto.setMemberBirth(memberBirthTF.getText());
		dto.setMemberTel(memberTelTF.getText());
		if (memberGenderRB.isSelected()) {
			dto.setMemberGender(0);
		} else {
			dto.setMemberGender(1);
		}
		dto.setMemberAdd(memberAddTF.getText());
		int result = dao.memberAdd(dto);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("회원 추가");
		if (result == 1) {
			alert.setHeaderText("회원 추가 성공");
			alert.showAndWait();
			memberIdTF.clear();
			memberPasswordPF.clear();
			memberNameTF.clear();
			memberBirthTF.clear();
			memberTelTF.clear();
			memberGenderRB.setSelected(true);
			memberAddTF.clear();
		} else {
			alert.setHeaderText("에러 발생");
			alert.show();
		}
		refreshMemberTableView();
	}
	
	public void memberChange(AdminDTO dto, Label testFx) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("회원 정보 변경");
		if (dto == null) {
			alert.setHeaderText("변경을 원하는 회원을 클릭해주세요");
			alert.show();
		} else {
			AdminMemberClass amc = new AdminMemberClass();
			amc.memberChangeFx(dto, testFx);
		}
	}
	
	public void memberChangeBtn(Parent root, AdminDTO dto) {
		AdminDAO dao = new AdminDAO();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("상품 변경");
		int num = memberInfo.getSelectionModel().getSelectedIndex();
		int selected;
		if (changeMemberMan.isSelected()) {
			selected = 0;
		} else {
			selected = 1;
		}
		if (Integer.parseInt(changeMemberNum.getText()) == dto.getMemberNum() 
				&& changeMemberId.getText().equals(dto.getMemberId())
				&& changeMemberPwd.getText().equals(dto.getMemberPassword())
				&& changeMemberName.getText().equals(dto.getMemberName())
				&& changeMemberBirth.getText().equals(dto.getMemberBirth())
				&& changeMemberTel.getText().equals(dto.getMemberTel())
				&& changeMemberAdd.getText().equals(dto.getMemberAdd())
				&& selected == dto.getMemberGender()) {
			alert.setHeaderText("내용을 변경해주세요");
			alert.show();
		} else {
			dto.setMemberNum(Integer.parseInt(changeMemberNum.getText()));
			dto.setMemberId(changeMemberId.getText());
			dto.setMemberPassword(changeMemberPwd.getText());
			dto.setMemberName(changeMemberName.getText());
			dto.setMemberBirth(changeMemberBirth.getText());
			dto.setMemberTel(changeMemberTel.getText());
			dto.setMemberAdd(changeMemberAdd.getText());
			if (changeMemberMan.isSelected()) {
				selected = 0;
			} else {
				selected = 1;
			}
			dto.setMemberGender(selected);
			int result = dao.memberChangBtn(dto);
			if (result == 1) {
				alert.setHeaderText("내용이 변경되었습니다.");
				alert.showAndWait();
				Stage stage = (Stage)root.getScene().getWindow();
				stage.close();
			} else {
				alert.setHeaderText("문제가 발생하였습니다. 값을 다시 입력해주세요");
				alert.show();
			}
			refreshMemberTableView();
		}
		memberInfo.getSelectionModel().select(num);
	}
	
	public void refreshMemberTableView() {
		memberList.removeAll(memberList);
		AdminDAO dao = new AdminDAO();
		ArrayList<AdminDTO> adminDTO = dao.getMember();
		for (int i = 0; i < adminDTO.size(); i++) {
			AdminDTO dto = adminDTO.get(i);
			memberList.add(new MemberData(dto.getMemberNum(),dto.getMemberId(), dto.getMemberPassword(), dto.getMemberName(),dto.getMemberBirth(),dto.getMemberTel(),dto.getMemberGender(),dto.getMemberAdd()));
		}
		memberNum.setCellValueFactory(new PropertyValueFactory<>("y_num"));
		memberId.setCellValueFactory(new PropertyValueFactory<>("y_id"));
		memberPassword.setCellValueFactory(new PropertyValueFactory<>("y_pwd"));
		memberName.setCellValueFactory(new PropertyValueFactory<>("y_name"));
		memberBirth.setCellValueFactory(new PropertyValueFactory<>("y_brith"));
		memberTel.setCellValueFactory(new PropertyValueFactory<>("y_tel"));
		memberGender.setCellValueFactory(new PropertyValueFactory<>("y_gender1"));
		memberAdd.setCellValueFactory(new PropertyValueFactory<>("y_add"));
		memberInfo.setItems(memberList);
	}
	
	public void setFxData(TableView memberInfo, TableColumn memberNum, TableColumn memberId,
			TableColumn memberPassword, TableColumn memberName, TableColumn memberBirth, TableColumn memberTel, 
			TableColumn memberGender, TableColumn memberAdd, TextField memberSearchTF) {
		this.memberInfo = memberInfo;
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberTel = memberTel;
		this.memberGender = memberGender;
		this.memberAdd = memberAdd;
		this.memberSearchTF = memberSearchTF;
	}
	
	public void setAddFxData(TextField memberIdTF, PasswordField memberPasswordPF, TextField memberNameTF,
			TextField memberBirthTF, TextField memberTelTF, RadioButton memberGenderRB, TextField memberAddTF) {
		this.memberIdTF = memberIdTF;
		this.memberPasswordPF = memberPasswordPF;
		this.memberNameTF = memberNameTF;
		this.memberBirthTF = memberBirthTF;
		this.memberTelTF = memberTelTF;
		this.memberGenderRB = memberGenderRB;
		this.memberAddTF = memberAddTF;
	}
	
	public void setMemberChangeFxData(TextField changeMemberNum, TextField changeMemberId, PasswordField changeMemberPwd, 
			TextField changeMemberName, TextField changeMemberBirth, TextField changeMemberTel, 
			TextField changeMemberAdd, RadioButton changeMemberMan, RadioButton changeMemberWoman) {
		this.changeMemberNum = changeMemberNum;
		this.changeMemberId = changeMemberId;
		this.changeMemberPwd = changeMemberPwd;
		this.changeMemberName = changeMemberName;
		this.changeMemberBirth = changeMemberBirth;
		this.changeMemberTel = changeMemberTel;
		this.changeMemberAdd = changeMemberAdd;
		this.changeMemberMan = changeMemberMan;
		this.changeMemberWoman = changeMemberWoman;
	}
	
	public void setCommonFxData(TableView memberInfo, TableColumn memberNum, TableColumn memberId,
			TableColumn memberPassword, TableColumn memberName, TableColumn memberBirth, TableColumn memberTel, 
			TableColumn memberGender, TableColumn memberAdd) {
		this.memberInfo = memberInfo;
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberTel = memberTel;
		this.memberGender = memberGender;
		this.memberAdd = memberAdd;
		this.memberList = memberList;
	}
	
}
























