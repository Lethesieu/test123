package DAO;



import DB.DBConnect;
import Model.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class slideSPDAO{
public static List<SanPham> getListslide() {
	 Connection conn = DBConnect.CreateConnection();
    String sql = "SELECT * FROM SanPham";
    List<SanPham> list = new ArrayList<SanPham>();
    try {
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	SanPham sp= new SanPham();
            sp.setMaSP(rs.getString("MaSP"));
            sp.setTenSP(rs.getString("TenSP"));
            sp.setMaCM(rs.getString("MaCM"));
            sp.setGia(rs.getLong("Gia"));
            sp.setHinhAnh(rs.getString("HinhAnh"));
           
            list.add(sp);
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
}
