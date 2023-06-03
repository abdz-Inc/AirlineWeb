

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.Admin;
import backend.Main;
import backend.User;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gmail = request.getParameter("gmail");
		String pas = request.getParameter("password");
		Connection conn = Main.createConnection();
		Admin admin = Admin.login(gmail, pas, conn);
		
		if(admin == null) {
			request.setAttribute("isNotValid", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminlogin.jsp");
		    dispatcher.forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.setAttribute("admin", admin);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminpage.jsp");
		    dispatcher.forward(request, response);
		}
	}

}
