

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;

import backend.BookTicket;
import backend.Main;
import backend.User;

/**
 * Servlet implementation class BookingHistoryServlet
 */
@WebServlet("/BookingHistoryServlet")
public class BookingHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentuser = (User) session.getAttribute("user");
		Connection conn = Main.createConnection();
		ArrayList<BookTicket> bookings = BookTicket.viewBookings(currentuser.getUid(), conn);
		if(bookings!= null)
		{
			request.setAttribute("hasBookings", true);
			request.setAttribute("hasNoBookings", false);
			
		}
		else {
			request.setAttribute("hasNoBookings", true);
			
		}
		request.setAttribute("bookings", bookings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mainpage.jsp");
	    dispatcher.forward(request, response);
		
	}

}
