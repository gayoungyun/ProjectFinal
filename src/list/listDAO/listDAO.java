package list.listDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import list.listDTO.listDTO;

public class listDAO 
{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public listDAO()
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
	
	public ArrayList<listDTO> bringAllDB()
	{
		String sql = "select * from productInfo";
		ArrayList<listDTO> list = new ArrayList<>();
		
		try 
		{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next())
			{
				int proNumber = rs.getInt("productNumber");
				String proName = rs.getString("productName");
				String proPrice = rs.getString("productPrice");
				String proImageRoot = rs.getString("productImageRoot");
				String proCategory = rs.getString("category");
				
				list.add(new listDTO(proNumber, proName, proPrice, proImageRoot, proCategory));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}

}
