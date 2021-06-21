package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.DBConnect;
import Model.TaiKhoan;


public class TaiKhoanDAO{
	public TaiKhoanDAO() {};
	
	public boolean checkEmail(String email)
	{
		Connection conn=DBConnect.CreateConnection();
		String sql="SELECT * FROM TaiKhoan WHERE UserEmail='"+email+"'";
		PreparedStatement ps;
	try {
		ps=conn.prepareCall(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		conn.close();
		return true;
		}
	}
	catch(SQLException ex){
		Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return false;
	}

	public static boolean insertTaiKhoan(TaiKhoan tk) 
	{
		Connection conn=DBConnect.CreateConnection();
		String sql="INSERT INTO taikhoan (UserEmail, Pass, PhanLoai)" + 
				"VALUES (?, ?, ?)";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);			
			ps.setString(1,tk.getUserEmail());
			ps.setString(2,tk.getPass());
			ps.setInt(3, tk.getPhanLoai());
			ps.executeUpdate();
			return true;
		}
		catch (SQLException ex){
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
		
	}


	public static TaiKhoan login(String UserEmail, String pass) {
	 Connection con = DBConnect.CreateConnection();
	 String sql = "select * from taikhoan where userEmail='" + UserEmail + "' and pass='" + pass + "'";
	 PreparedStatement ps;
	 try {
	 ps = (PreparedStatement) con.prepareStatement(sql);
	 ResultSet rs = ps.executeQuery();
	 if (rs.next()) {
		 TaiKhoan tk=new TaiKhoan();
		 tk.setID(rs.getInt("ID"));
		 tk.setUserEmail(rs.getString("UserEmail"));
		 tk.setPass(rs.getString("Pass"));
		 tk.setPhanLoai(rs.getInt("PhanLoai"));
		  tk.setHoTen(rs.getString("HoTen"));
          tk.setGioiTinh(rs.getString("GioiTinh"));
          tk.setSDT(rs.getString("SDT"));
		 con.close();
		 return tk;
	 }
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 return null;
	}

	public static ArrayList<TaiKhoan> getListTaiKhoan() {
	    Connection cons = DBConnect.CreateConnection();
	    String sql = "SELECT * FROM TaiKhoan";
	    ArrayList<TaiKhoan> list = new ArrayList<>();
	    try {
	        PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            TaiKhoan tk= new TaiKhoan();
	            tk.setID(rs.getInt("ID"));
	            tk.setUserEmail(rs.getString("UserEmail"));
	            tk.setPass(rs.getString("Pass"));
	            tk.setHoTen(rs.getString("HoTen"));
	            tk.setGioiTinh(rs.getString("GioiTinh"));
	            tk.setSDT(rs.getString("SDT"));
	            tk.setPhanLoai(rs.getInt("PhanLoai"));
	            list.add(tk);
	        }
	        cons.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	//f5
	public static boolean UpdateInfo(TaiKhoan tk) 
	{
		Connection conn=DBConnect.CreateConnection();
		String sql="Update taikhoan set HoTen=?, GioiTinh=?, SDT=? where ID=?";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);			
			ps.setString(1,tk.getHoTen());
			ps.setString(2,tk.getGioiTinh());
			ps.setString(3, tk.getSDT());
			ps.setInt(4, tk.getID());
			ps.executeUpdate();
			return true;
		}
		catch (SQLException ex){
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
		
	}
	
	public static boolean insert_TaiKhoan(TaiKhoan tk) throws SQLException {
	try {
	    Connection connection = DBConnect.CreateConnection();
	    String sql = "INSERT INTO TaiKhoan VALUE(?,?,?,?,?,?,?)";
	    PreparedStatement ps = connection.prepareCall(sql);
	    ps.setInt(1, tk.getID());
	    ps.setString(2, tk.getUserEmail());
	    ps.setString(3, tk.getPass());
	    ps.setString(4, tk.getHoTen());
	    ps.setString(5, tk.getGioiTinh());
	    ps.setString(6, tk.getSDT());
	    ps.setInt(7, tk.getPhanLoai());
	    int temp = ps.executeUpdate();
	    return temp == 1;
	} catch (Exception e) {
	    return false;
	}
	}

	//f5
	public static boolean update_TaiKhoan(TaiKhoan tk) throws SQLException {
	try {
	    Connection connection = DBConnect.CreateConnection();
	    String sql = "UPDATE TaiKhoan SET UserEmail = ? ,Pass=?, HoTen=?,GioiTinh=?,SDT=?,PhanLoai=? WHERE ID = ?";
	    PreparedStatement ps = connection.prepareCall(sql);
	    ps.setString(1, tk.getUserEmail());
	    ps.setString(2, tk.getPass());
	    ps.setString(3, tk.getHoTen());
	    ps.setString(4, tk.getGioiTinh());
	    ps.setString(5, tk.getSDT());
	    ps.setInt(6, tk.getPhanLoai());
	    ps.setInt(7, tk.getID());
	    int temp = ps.executeUpdate();
	    return temp == 1;
	} catch (Exception e) {
	    return false;
	}
	}

	public static boolean delete_TaiKhoan(int ID) throws SQLException {
	try {
	   Connection connection = DBConnect.CreateConnection();
	   String sql = "DELETE FROM TaiKhoan WHERE ID = ?";
	   PreparedStatement ps = connection.prepareCall(sql);
	   ps.setInt(1, ID);
	   int temp = ps.executeUpdate();
	       return temp == 1;
	} catch (Exception e) {
	   return false;
	}
	}
}