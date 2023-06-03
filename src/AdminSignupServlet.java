

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.*;

/**
 * Servlet implementation class AdminSignupServlet
 */
@WebServlet("/AdminSignupServlet")
public class AdminSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Admin currentadmin = (Admin) session.getAttribute("admin");
		
		if(currentadmin!= null)
		{	
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
	        String gmail = request.getParameter("gmail");
	        String password = request.getParameter("password");
	        Long phone = Long.parseLong(request.getParameter("phone"));
	        
	        Connection conn = Main.createConnection();
	        Admin admin = new Admin(id, password, name, gmail, phone);
	        admin.addAdmin(admin, conn);
	        
	        if(admin != null)
	        	{
	        	request.setAttribute("isNotValid", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminsignup.jsp");
			    dispatcher.forward(request, response);
	        	}
	        else {
	        	request.setAttribute("isNotValid", true);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminsignup.jsp");
			    dispatcher.forward(request, response);
	        }
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminlogin.jsp");
		    dispatcher.forward(request, response);
		}
		
	}

}
