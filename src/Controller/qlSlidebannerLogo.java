package Controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.slidebannerLogoDAO;
import Model.slidebannerLogo;





@WebServlet("/qlSlidebannerLogo")
public class qlSlidebannerLogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	slidebannerLogoDAO slidebannerDAO = new slidebannerLogoDAO();

    public qlSlidebannerLogo() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		String command = request.getParameter("command");
		String ma_slide = request.getParameter("ma_slide");
		
		
		String url ="";
		try {
			
				switch (command) {
				case "delete":
					slidebannerLogoDAO.delete_slidebanner(Long.parseLong(ma_slide));
					url = "/SlidebannerlogoQL";
					break;
				}
			
		} catch (Exception e) {
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		String ten = request.getParameter("ten");
		String ma = request.getParameter("ma");
		String ma_slide = request.getParameter("ma_slide");
		String url = "", error = "";
		if(ten.equals("")) {
			error = "Vui lòng nhập tên danh mục!";
			request.setAttribute("error", error);
		}
		
		try {
			if(error.length()==0) {
				switch (command) {
				case "insert":
					slidebannerLogoDAO.insert_SlidebannerLogo(new slidebannerLogo(Long.parseLong(ma),ten));
					
				
					url = "/SlidebannerlogoQL";
				break;
				case "update":
					slidebannerLogoDAO.update_slidebannerLogo(new slidebannerLogo(Long.parseLong(ma_slide),ten));
					
					url = "/SlidebannerlogoQL";
					break;
				}
			}
			else {
				url = "/addSlidebannerLogo";
			}
		} catch (Exception e) {
		
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}


}