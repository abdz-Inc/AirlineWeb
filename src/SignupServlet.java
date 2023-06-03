

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.Main;
import backend.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String gmail = request.getParameter("gmail");
        String password = request.getParameter("password");
        Long phone = Long.parseLong(request.getParameter("phone"));
        
        Connection conn = Main.createConnection();
        User currentuser = new User(password, name, gmail, phone);
        currentuser.signup(conn);
        
        if(currentuser != null)
        	{
        	HttpSession session = request.getSession();
        	session.setAttribute("user", currentuser);
        	request.setAttribute("user", currentuser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mainpage.jsp");
		    dispatcher.forward(request, response);
        	}
        else {
        	request.setAttribute("isNotValid", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
		    dispatcher.forward(request, response);
        }

       
	}

}
