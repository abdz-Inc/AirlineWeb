

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
 * Servlet implementation class ConfirmBooking
 */
@WebServlet("/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tid = Integer.parseInt(request.getParameter("tripid"));
		int seats = Integer.parseInt(request.getParameter("seats"));
		System.out.println(tid);
		HttpSession session = request.getSession();
		User currentuser = (User) session.getAttribute("user");
		
		Connection conn = Main.createConnection();
		
		BookTicket ticket = BookTicket.bookTicket(currentuser.getUid(), tid, seats, conn);
		if(ticket != null)
		{
			request.setAttribute("name", currentuser.getName());
			request.setAttribute("tid", tid);
			request.setAttribute("amount", ticket.getAmount());
			request.setAttribute("bid", ticket.getBookid());
			RequestDispatcher dispatcher = request.getRequestDispatcher("bookingsuccess.jsp");
		    dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("nullTripid", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mainpage.jsp");
		    dispatcher.forward(request, response);
		}
		
	}

}
