package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBConnect;
import Model.ChiTietSanPham;

public class ChiTietSPDAO{
public static ArrayList<ChiTietSanPham> getListChiTietSanPham() {
    Connection cons = DBConnect.CreateConnection();
    String sql = "SELECT * FROM ChiTietSP";
    ArrayList<ChiTietSanPham> list = new ArrayList<>();
    try {
        PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChiTietSanPham ctsp= new ChiTietSanPham();
            ctsp.setMaSP(rs.getString("MaSP"));
            ctsp.setNgaySX(rs.getString("NgaySX"));
            ctsp.setHanSD(rs.getString("HanSD"));
            ctsp.setXuatSu(rs.getString("XuatSu"));
            ctsp.setNoiSX(rs.getString("NoiSX"));
            ctsp.setHuongDanSD(rs.getString("HuongDanSD"));
            list.add(ctsp);
        }
        cons.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

public ChiTietSanPham getChiTietSP(String MaSP) throws SQLException{

	Connection conn=DBConnect.CreateConnection();
	String sql="SELECT * FROM ChiTietSP WHERE MaSP='"+MaSP+"'";
	PreparedStatement ps=conn.prepareCall(sql);
	ResultSet rs=ps.executeQuery();
	ChiTietSanPham ctsp=new ChiTietSanPham();
	while(rs.next())
	{
		ctsp.setNgaySX(rs.getString("NgaySX"));
		ctsp.setHanSD(rs.getString("HanSD"));
		ctsp.setXuatSu(rs.getString("XuatSu"));
		ctsp.setNoiSX(rs.getString("NoiSX"));
		ctsp.setHuongDanSD(rs.getString("HuongDanSD"));
	}
	return ctsp;
	}


public static boolean insert_ChiTietSanPham(ChiTietSanPham ctsp) throws SQLException {
try {
  Connection connection = DBConnect.CreateConnection();
  String sql = "INSERT INTO ChiTietSP VALUE(?,?,?,?,?,?)";
  PreparedStatement ps = connection.prepareCall(sql);
  ps.setString(1, ctsp.getMaSP());
  ps.setString(2,ctsp.getNgaySX());
  ps.setString(3, ctsp.getHanSD());
  ps.setString(4, ctsp.getXuatSu());
  ps.setString(5, ctsp.getNoiSX());
  ps.setString(6, ctsp.getHuongDanSD());
  int temp = ps.executeUpdate();
  return temp == 1;
} catch (Exception e) {
  return false;
}
}


public static boolean update_ChiTietSanPham(ChiTietSanPham ctsp) throws SQLException {
try {
  Connection connection = DBConnect.CreateConnection();
  String sql = "UPDATE ChiTietSP SET NgaySX = ? ,HanSD=?, XuatSu=?,NoiSX=? ,HuongDanSD=? WHERE MaSP = ?";
  PreparedStatement ps = connection.prepareCall(sql);
  ps.setString(1, ctsp.getNgaySX());
  ps.setString(2, ctsp.getHanSD());
  ps.setString(3, ctsp.getXuatSu());
  ps.setString(4, ctsp.getNoiSX());
  ps.setString(5, ctsp.getHuongDanSD());
  ps.setString(6, ctsp.getMaSP());
  int temp = ps.executeUpdate();
  return temp == 1;
} catch (Exception e) {
  return false;
}
}


public static boolean delete_ChiTietSanPham(String MaSP) throws SQLException {
try {
 Connection connection = DBConnect.CreateConnection();
 String sql = "DELETE FROM ChiTietSP WHERE MaSP = ?";
 PreparedStatement ps = connection.prepareCall(sql);
 ps.setString(1, MaSP);
 int temp = ps.executeUpdate();
     return temp == 1;
} catch (Exception e) {
 return false;
}
}
}