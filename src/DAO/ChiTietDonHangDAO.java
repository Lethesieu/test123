package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.DBConnect;
import Model.ChiTietDonHang;

public class ChiTietDonHangDAO{
public static ArrayList<ChiTietDonHang> getListChiTietDonHang() {
    Connection cons = DBConnect.CreateConnection();
    String sql = "SELECT * FROM chitietdonhang";
    ArrayList<ChiTietDonHang> list = new ArrayList<>();
    try {
        PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChiTietDonHang ctdh= new ChiTietDonHang();
            ctdh.setMaDH(rs.getString("MaDH"));
            ctdh.setMaSP(rs.getString("MaSP"));
            ctdh.setGia(rs.getLong("Gia"));
            ctdh.setSoLuong(rs.getInt("SoLuong"));
            ctdh.setNgayDH(rs.getTimestamp("NgayDH"));
            ctdh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
            list.add(ctdh);
        }
        cons.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

	public static boolean insertChiTietDonHang(ChiTietDonHang ctdh) 
	{
		Connection conn=DBConnect.CreateConnection();
		String sql="INSERT INTO ChiTietDonHang VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);			
			ps.setString(1,ctdh.getMaDH());
			ps.setString(2,ctdh.getMaSP());
			ps.setLong(3, ctdh.getGia());
			ps.setInt(4,ctdh.getSoLuong());
			ps.setTimestamp(5, ctdh.getNgayDH());
			ps.setString(6, ctdh.getHinhThucThanhToan());
			ps.executeUpdate();
			return true;
		}
		catch (SQLException ex){
			Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
		
	}

}