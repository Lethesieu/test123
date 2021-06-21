package DAO;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ChuyenMuc;

public class ChuyenMucDAO{
public static ArrayList<ChuyenMuc> getListChuyenMuc() {
    Connection cons = DBConnect.CreateConnection();
    String sql = "SELECT * FROM ChuyenMuc";
    ArrayList<ChuyenMuc> list = new ArrayList<>();
    try {
        PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChuyenMuc CM= new ChuyenMuc();
            CM.setMaCM(rs.getString("MaCM"));
            CM.setTenCM(rs.getString("TenCM"));
            list.add(CM);
        }
        cons.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

public static boolean insert_ChuyenMuc(ChuyenMuc c) throws SQLException {
 try {
      Connection connection = DBConnect.CreateConnection();
      String sql = "INSERT INTO ChuyenMuc VALUE(?,?)";
      PreparedStatement ps = connection.prepareCall(sql);
      ps.setString(1, c.getMaCM());
      ps.setString(2, c.getTenCM());
      int temp = ps.executeUpdate();
      return temp == 1;
 } catch (Exception e) {
      return false;
 }
}


public static boolean update_ChuyenMuc(ChuyenMuc c) throws SQLException {
 try {
      Connection connection = DBConnect.CreateConnection();
      String sql = "UPDATE ChuyenMuc SET TenCM = ? WHERE MaCM = ?";
      PreparedStatement ps = connection.prepareCall(sql);
      ps.setString(1, c.getTenCM());
      ps.setString(2, c.getMaCM());
      int temp = ps.executeUpdate();
      return temp == 1;
 } catch (Exception e) {
      return false;
 }
}

//
public static boolean delete_ChuyenMuc(String MaCM) throws SQLException {
 try {
     Connection connection = DBConnect.CreateConnection();
     String sql = "DELETE FROM ChuyenMuc WHERE MaCM = ?";
     PreparedStatement ps = connection.prepareCall(sql);
     ps.setString(1, MaCM);
     int temp = ps.executeUpdate();
         return temp == 1;
 } catch (Exception e) {
     return false;
 }
}
}