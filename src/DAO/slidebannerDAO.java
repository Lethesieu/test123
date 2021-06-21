package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import Model.slidebanner;

public class slidebannerDAO{
public static List<slidebanner> getListslidebanner() {
	 Connection conn = DBConnect.CreateConnection();
    String sql = "SELECT * FROM slidebanner";
    List<slidebanner> list = new ArrayList<slidebanner>();
    try {
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            slidebanner sl= new slidebanner();
            sl.setSlidebannerID(rs.getInt("slidebannerID"));
            sl.setSlidebannerImage(rs.getString("slidebannerImage"));
           
            list.add(sl);
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}



public static boolean insert_Slidebanner(slidebanner c) throws SQLException {
 try {
      Connection connection = DBConnect.CreateConnection();
      String sql = "INSERT INTO slidebanner VALUE(?,?)";
      PreparedStatement ps = connection.prepareCall(sql);
      ps.setLong(1, c.getSlidebannerID());
      ps.setString(2, c.getSlidebannerImage());
      int temp = ps.executeUpdate();
      return temp == 1;
 } catch (Exception e) {
      return false;
 }
}

public static boolean update_slidebanner(slidebanner c) throws SQLException {
 try {
      Connection connection = DBConnect.CreateConnection();
      String sql = "UPDATE slidebanner SET slidebannerImage = ? WHERE slidebannerID = ?";
      PreparedStatement ps = connection.prepareCall(sql);
      
      ps.setString(1, c.getSlidebannerImage());
      ps.setLong(2, c.getSlidebannerID());
      int temp = ps.executeUpdate();
      return temp == 1;
 } catch (Exception e) {
      return false;
 }
}

public static boolean delete_slidebanner(long MaSlide) throws SQLException {
 try {
     Connection connection = DBConnect.CreateConnection();
     String sql = "DELETE FROM slidebanner WHERE slidebannerID = ?";
     PreparedStatement ps = connection.prepareCall(sql);
     ps.setLong(1, MaSlide);
     int temp = ps.executeUpdate();
         return temp == 1;
 } catch (Exception e) {
     return false;
 }
}

public static void main(String[] args) throws SQLException{
	slidebannerDAO dao = new slidebannerDAO();
	//System.out.println(dao.update_slidebanner(new slidebanner(1,"banner3.jpg")));
	System.out.println(dao. insert_Slidebanner(new slidebanner(8,"banner3.jpg")));
}

}