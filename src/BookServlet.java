

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.User;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentuser = (User) session.getAttribute("user");
		String tripid = request.getParameter("button");
		if(currentuser == null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("sessiontimeout.html");
		    dispatcher.forward(request, response);
		}
		else if(tripid == null)
		{
			request.setAttribute("nullTripid", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mainpage.jsp");
		    dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("userid", currentuser.getUid());
			request.setAttribute("tripid", tripid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("book.jsp");
		    dispatcher.forward(request, response);
		}
		
		
	}

}
