package DAO;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.KhoHang;

public class KhoHangDAO{

//Danh sách Kho hàng
public static ArrayList<KhoHang> ListKhoHang() {
    Connection cons = DBConnect.CreateConnection();
    String sql = "SELECT * FROM KhoHang";
    ArrayList<KhoHang> list = new ArrayList<>();
    try {
        PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            KhoHang kh= new KhoHang();
            kh.setMaSP(rs.getString("MaSP"));
            kh.setSoLuong(rs.getInt("SoLuong"));
            kh.setGhiChu(rs.getString("GhiChu"));
          
            list.add(kh);
        }
        cons.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

}