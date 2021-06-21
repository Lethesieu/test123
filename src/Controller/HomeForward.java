package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import DAO.slideSPDAO;
import DAO.slidebannerDAO;
import DAO.slidebannerLogoDAO;
import Model.SanPham;
import Model.slidebanner;
import Model.slidebannerLogo;

@WebServlet(urlPatterns="/HomeForward",loadOnStartup=1)
public class HomeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeForward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		List<slidebanner> list = slidebannerDAO.getListslidebanner();

		request.setAttribute("listslidebanner", list);
		List<slidebannerLogo> listLogo = slidebannerLogoDAO.getListslidebannerLogo();

		request.setAttribute("listslidebannerLogo", listLogo);
		
		List<SanPham> listSP = slideSPDAO.getListslide();

		request.setAttribute("listsp", listSP);
		/// mới viết
		List<SanPham> listsp111= SanPhamDAO.getListSanPham();
		request.setAttribute("listsp111", listsp111);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	
		

		List<slidebanner> list = slidebannerDAO.getListslidebanner();
		request.setAttribute("listslidebanner", list);
		List<slidebannerLogo> listLogo = slidebannerLogoDAO.getListslidebannerLogo();

		request.setAttribute("listslidebannerLogo", listLogo);
		
		List<SanPham> listSP = slideSPDAO.getListslide();

		request.setAttribute("listsp", listSP);
		List<SanPham> listsp111= SanPhamDAO.getListSanPham();
		request.setAttribute("listsp111", listsp111);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
