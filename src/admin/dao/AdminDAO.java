package admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.dto.AdminDTO;

public class AdminDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AdminDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String id = "java";
			String pwd = "1234";
			con = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AdminDTO> getProduct(String product) {
		String sql = "select * from productInfo where category = ? order by productnumber";
		ArrayList<AdminDTO> adminDTO= new ArrayList<>(); 
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product);
			rs = ps.executeQuery();
			while (rs.next()) {
				AdminDTO dto = new AdminDTO();
				dto.setProductNumber(rs.getInt("productNumber"));
				dto.setProductName(rs.getString("productName"));
				dto.setProductPrice(rs.getString("productPrice"));
				dto.setProductImageRoot(rs.getString("productImageRoot"));
				dto.setProductCategory(rs.getString("category"));
				adminDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminDTO;
	}
	
	public ArrayList<AdminDTO> getProduct() {
		String sql = "select * from productInfo order by productnumber";
		ArrayList<AdminDTO> adminDTO= new ArrayList<>(); 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AdminDTO dto = new AdminDTO();
				dto.setProductNumber(rs.getInt("productNumber"));
				dto.setProductName(rs.getString("productName"));
				dto.setProductPrice(rs.getString("productPrice"));
				dto.setProductImageRoot(rs.getString("productImageRoot"));
				dto.setProductCategory(rs.getString("category"));
				adminDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminDTO;
	}
	
	public int productChangBtn(AdminDTO dto) {
		int result = 0;
		String sql = "update productInfo set productname = ?, productprice = ?, "
				+ "productimageroot = ?, category = ? where productnumber = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getProductName());
			ps.setString(2, dto.getProductPrice());
			ps.setString(3, dto.getProductImageRoot());
			ps.setString(4, dto.getProductCategory());
			ps.setInt(5, dto.getProductNumber());
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int memberChangBtn(AdminDTO dto) {
		int result = 0;
		String sql = "update memberdatainfo set y_id = ?, y_pwd = ?, y_name = ?, y_brith = ?, "
				+ "y_tel = ?, y_gender = ?, y_add = ? where y_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMemberId());
			ps.setString(2, dto.getMemberPassword());
			ps.setString(3, dto.getMemberName());
			ps.setString(4, dto.getMemberBirth());
			ps.setString(5, dto.getMemberTel());
			ps.setInt(6, dto.getMemberGender());
			ps.setString(7, dto.getMemberAdd());
			ps.setInt(8, dto.getMemberNum());
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<AdminDTO> getMember() {
		String sql = "select * from memberdatainfo order by y_num";
		ArrayList<AdminDTO> adminDTO = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AdminDTO dto = new AdminDTO();
				dto.setMemberNum(rs.getInt("y_num"));
				dto.setMemberId(rs.getString("y_id"));
				dto.setMemberPassword(rs.getString("y_pwd"));
				dto.setMemberName(rs.getString("y_name"));
				dto.setMemberBirth(rs.getString("y_brith"));
				dto.setMemberTel(rs.getString("y_tel"));
				dto.setMemberGender(rs.getInt("y_gender"));
				dto.setMemberAdd(rs.getString("y_add"));
				adminDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminDTO;
	}
	
	public ArrayList<AdminDTO> memberSearch(String id) {
		ArrayList<AdminDTO> dtoList = new ArrayList<>();
		System.out.println("멤버서치메서드 실행");
		AdminDTO dto = null;
		String sql = "select * from memberdatainfo where y_id like ?";
		System.out.println("쿼리문 작성");
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + id + "%");
			rs = ps.executeQuery();
			System.out.println("와일문 실행전");
			while (rs.next()) {
				dto = new AdminDTO();
				dto.setMemberNum(rs.getInt("y_num"));
				dto.setMemberId(rs.getString("y_id"));
				dto.setMemberPassword(rs.getString("y_pwd"));
				dto.setMemberName(rs.getString("y_name"));
				dto.setMemberBirth(rs.getString("y_brith"));
				dto.setMemberTel(rs.getString("y_tel"));
				dto.setMemberGender(rs.getInt("y_gender"));
				dto.setMemberAdd(rs.getString("y_add"));
				dtoList.add(dto);
				System.out.println(dto.getMemberNum());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	

	
	public int productDelete(AdminDTO dto) {
		int num = 0;
		String sql = "delete from productInfo where productNumber = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getProductNumber());
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int memberDelete(AdminDTO dto) {
		int num = 0;
		String sql = "delete from memberdatainfo where y_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getMemberNum());
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int productAdd(AdminDTO dto) {
		String sql = "insert into productInfo values (?, ?, ?, ?, ?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getProductNumber());
			ps.setString(2, dto.getProductName());
			ps.setString(3, dto.getProductPrice());
			ps.setString(4, dto.getProductImageRoot());
			ps.setString(5, dto.getProductCategory());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int memberAdd(AdminDTO dto) {
		String sql = "insert into memberdatainfo values (?,"
				+ " ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getMemberNum());
			ps.setString(2, dto.getMemberId());
			ps.setString(3, dto.getMemberPassword());
			ps.setString(4, dto.getMemberName());
			ps.setString(5, dto.getMemberBirth());
			ps.setString(6, dto.getMemberTel());
			ps.setInt(7, dto.getMemberGender());
			ps.setString(8, dto.getMemberAdd());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int searchMemNumber() {
		String sql = "select max(y_num)+1 from memberdatainfo";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			result = rs.getInt("max(y_num)+1");
			if (result == 0) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String setImageView(AdminDTO dto) {
		String imageRoot = null;
		String sql = "select productImageRoot from productInfo where productNumber = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getProductNumber());
			rs = ps.executeQuery();
			rs.next();
			imageRoot = rs.getString("productImageRoot");
		} catch (Exception e) {
			
		}
		return imageRoot;
	}
	
	public int searchProdNumber() {
		String sql = "select max(productnumber)+1 from productinfo";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			result = rs.getInt("max(productnumber)+1");
			if (result == 0) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
