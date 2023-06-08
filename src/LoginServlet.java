import backend.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gmail = request.getParameter("gmail");
		String pas = request.getParameter("password");
		Connection conn = Main.createConnection();
		User currentuser = User.login(gmail, pas, conn);
		
		if(currentuser == null) {
			request.setAttribute("isNotValid", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", currentuser);
			request.setAttribute("user", currentuser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mainpage.jsp");
		    dispatcher.forward(request, response);
		}
	}

}
