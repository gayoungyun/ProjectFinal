package login.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import javafx.scene.control.Alert;
import login.dto.LoginDTO;

public class LoginDAO {
	public static Object db;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	
	public LoginDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "c##java", pwd = "1234";
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void loginFunc(String id, String pw) {
		String sql = "select * from memberdatainfo where y_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int num = ps.executeUpdate();
			System.out.println(num);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getString("y_id"));
//				System.out.println(rs.getString("y_pwd"));
//				System.out.println(rs.getString("y_name"));
//				System.out.println(rs.getString("y_brith"));
//				
//			}
			if( num == 0) {
				System.out.println("등록되지 않은 회원");
			}else { 
				System.out.println("등록된 회원");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
