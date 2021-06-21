package Controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.slidebannerDAO;
import Model.slidebanner;


@WebServlet("/qlSlideBanner")
public class qlSlideBanner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	slidebannerDAO slidebannerDAO = new slidebannerDAO();

    public qlSlideBanner() {
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
					slidebannerDAO.delete_slidebanner(Long.parseLong(ma_slide));
					url = "/SlidebannerQL";
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
					slidebannerDAO.insert_Slidebanner(new slidebanner(Long.parseLong(ma),ten));
				
					url = "/SlidebannerQL";
				break;
				case "update":
					slidebannerDAO.update_slidebanner(new slidebanner(Long.parseLong(ma_slide), ten));
					
					url = "/SlidebannerQL";
					break;
				}
			}
			else {
				url = "/addSlidebanner";
			}
		} catch (Exception e) {
		
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}


}