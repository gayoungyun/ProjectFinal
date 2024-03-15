package login.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.net.ssl.HttpsURLConnection;

import admin.main.AdminProductClass;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import list.mainclass.MainClass;
import login.dto.LoginDTO;

public class LoginDAO {
	public static Object db;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public LoginDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String id = "java", pwd = "1234";
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loginFunc(String id, String pw, Parent root) {
		String sql = "select * from memberdatainfo where y_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int num = ps.executeUpdate();
			System.out.println(num);
			if( num == 0) {
				System.out.println("등록되지 않은 회원");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("등록되지 않은 사용자 입니다.");
				alert.show();
			}else { 
				System.out.println("등록된 회원");
				
				mainpage.mainclass.MainClass ms = new mainpage.mainclass.MainClass();
				
				System.out.println(id.equals("hong"));
				
				// 관리자 계정일 경우 추가하기
				if(id.equals("hong"))
				{
					AdminProductClass apc = new AdminProductClass();
					apc.start(root);
				}
				else
				{
					ms.mainPageOn(root);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String search_IdFunc(String name, String ph) {
		String id = null;
		try {
			String sql = "select * from memberdatainfo where y_name = ? and y_tel = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, ph);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				id = rs.getString("y_id");
				System.out.println(id);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Searching ID");
				alert.setHeaderText("Searching ID");
				alert.setContentText(name + "님의 ID : " + id);
				alert.show();
				
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("등록되지 않은 사용자 입니다.");
				alert.show();
				System.out.println("fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public String search_PwdFunc(String id, String ph) {
		String pwd = null;
		String name;
		try {
			String sql = "select * from memberdatainfo where y_id = ? and y_tel = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, ph);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				pwd = rs.getString("y_pwd");
				name = rs.getString("y_name");
				System.out.println(id);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Searching PWD");
				alert.setHeaderText("Searching PWD");
				alert.setContentText(name + "님의 PWD : " + pwd);
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("등록되지 않은 사용자 입니다.");
				alert.show();
				System.out.println("fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}
}
