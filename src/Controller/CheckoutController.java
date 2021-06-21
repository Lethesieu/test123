package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import Model.Cart;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.Items;
import Model.TaiKhoan;


@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CheckoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
		String payment=request.getParameter("payment");
	String address=request.getParameter("address");
	String phone=request.getParameter("phone");
	HttpSession session= request.getSession();
	Cart cart=(Cart) session.getAttribute("cart");
	TaiKhoan tk=(TaiKhoan) session.getAttribute("user");
	try {
		long millis=System.currentTimeMillis();  
		int ID= tk.getID();
		String user=tk.getHoTen();
		String idhd= String.valueOf(ID);
		String userorder=String.valueOf(user);
		DonHang dh=new DonHang();
		dh.setMaDH("DH"+idhd);
		dh.setID(ID);
		dh.setTongTien(cart.sumTotalCart());
		dh.setDiaChiNhan(address);
		dh.setSdt(phone);
		dh.setTennguoimua(userorder);
		DonHangDAO.insertDonHang(dh);
		if (DonHangDAO.insertDonHang(dh)==false) {
			System.out.println("Ôi bạn đang có 1 đơn hàng đang chờ được xử lý..vui lòng thanh toán rồi đặt hàng tiếp bạn nhé !");
			session.setAttribute("fixoder", "Ôi bạn đang có 1 đơn hàng đang chờ được xử lý..vui lòng thanh toán rồi đặt hàng tiếp bạn nhé !");
			
		}
		
		
		for(Map.Entry<String, Items> list: cart.getCartItems().entrySet()) {		
		ChiTietDonHangDAO.insertChiTietDonHang
		(new ChiTietDonHang("DH"+idhd,list.getKey(),list.getValue().getSanpham().getGia(),list.getValue().getSoLuong(),new Timestamp(new Date(millis).getTime()),payment));
		}
		 cart=new Cart();
		session.setAttribute("cart", cart);
		
	}
	catch (Exception e) {
		
	}
	response.sendRedirect("/DemoDisplaynew/HomeForward");
	}
}
