package buypage.buypageDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyPageDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public BuyPageDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String id ="java", pwd = "1234";
			con = DriverManager.getConnection(url,id, pwd);
			System.out.println("db연결 성공!!");
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}
	}
	
	
	public void setBill(int userNumber, int productNumber, String productName, String productPrice, String productCategory)
	{
		String sql = "insert into productBill VALUES ( ?, ?, ?, ?, ?)";
		
		try 
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNumber); // 나중에 유저넘버 추가
			ps.setInt(2, productNumber);
			ps.setString(3, productName);
			ps.setString(4, productPrice);
			ps.setString(5, productCategory);
			
			rs = ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
}
