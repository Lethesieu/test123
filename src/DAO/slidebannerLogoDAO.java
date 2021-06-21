package DAO;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.slidebanner;
import Model.slidebannerLogo;

public class slidebannerLogoDAO{
public static List<slidebannerLogo> getListslidebannerLogo() {
	Connection conn = DBConnect.CreateConnection();
    String sql = "SELECT * FROM slidebannerLogo";
    List<slidebannerLogo> list = new ArrayList<slidebannerLogo>();
    try {
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	slidebannerLogo sl= new slidebannerLogo();
            sl.setSlidebannerLogoID(rs.getInt("slidebannerLogoID"));
            sl.setSlidebannerLogoName(rs.getString("slidebannerLogoName"));
           
            list.add(sl);
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;	
}

//
public static boolean insert_SlidebannerLogo(slidebannerLogo c) throws SQLException {
try {
    Connection connection = DBConnect.CreateConnection();
    String sql = "INSERT INTO slidebannerLogo VALUE(?,?)";
    PreparedStatement ps = connection.prepareCall(sql);
    ps.setLong(1, c.getSlidebannerLogoID());
    ps.setString(2, c.getSlidebannerLogoName());
    int temp = ps.executeUpdate();
    return temp == 1;
} catch (Exception e) {
    return false;
}
}

//f5
public static boolean update_slidebannerLogo(slidebannerLogo c) throws SQLException {
try {
    Connection connection = DBConnect.CreateConnection();
    String sql = "UPDATE slidebannerLogo SET slidebannerLogoName = ? WHERE slidebannerLogoID = ?";
    PreparedStatement ps = connection.prepareCall(sql);
    
    ps.setString(1, c.getSlidebannerLogoName());
    ps.setLong(2, c.getSlidebannerLogoID());
    int temp = ps.executeUpdate();
    return temp == 1;
} catch (Exception e) {
    return false;
}
}

//xoa
public static boolean delete_slidebanner(long MaSlide) throws SQLException {
try {
   Connection connection = DBConnect.CreateConnection();
   String sql = "DELETE FROM slidebannerLogo WHERE slidebannerLogoID = ?";
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