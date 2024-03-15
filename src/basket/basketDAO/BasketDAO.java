package basket.basketDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basket.basketDTO.BasketDTO;
import list.listDTO.listDTO;

public class BasketDAO 
{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static int k = 2;
	int i = 1;
	
	public BasketDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String id ="java", pwd = "1234";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("db연결 성공!!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<BasketDTO> bringBaskeyDB(int userNumber)
	{
		String sql = "select * from userBasket where Y_num = ?";
		ArrayList<BasketDTO> list = new ArrayList<>();
		
		try 
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, "1");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				int usernum = rs.getInt("Y_num");
				String productName = rs.getString("productName");
				String productPrice= rs.getString("productPrice");
				String productImageRoot = rs.getString("productImageRoot");
				String productCategory = rs.getString("productCategory");
				int productNumber = rs.getInt("productNumber");
				
				list.add(new BasketDTO(usernum, i, productNumber, productName, productPrice, productImageRoot, productCategory));
				i++;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		i = 1;
		
		return list;
	}
	
	public void insertBaskeyProduct(listDTO LDTO, int userNumber)
	{
		String sql = "insert into userBasket VALUES ( ?, ?, ?, ?, ?, ?)";
		
		try 
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, "1"); // 나중에 유저넘버 추가
			ps.setString(2, LDTO.getProductName());
			ps.setString(3, LDTO.getProductPrice());
			ps.setString(4, LDTO.getProductIamgeRoot());
			ps.setString(5, LDTO.getProductCategory());
			ps.setInt(6, k++);
			rs = ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void deleteBasketProduct(int number)
	{
		String sql = "delete from userBasket where productNumber = ?";
		
		try 
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, number); // 나중에 유저넘버 추가
			System.out.println(ps.executeUpdate());
			rs = ps.executeQuery();
			
		} 
		catch (SQLException e) 
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
