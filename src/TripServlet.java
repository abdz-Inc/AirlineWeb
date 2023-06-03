

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
import backend.Flight;
import backend.Main;
import backend.Trip;

/**
 * Servlet implementation class TripServlet
 */
@WebServlet("/TripServlet")
public class TripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin currentadmin = (Admin) session.getAttribute("admin");
		
		if(currentadmin!= null)
		{
			Connection conn = Main.createConnection();
			int no = Integer.parseInt(request.getParameter("tripno"));
			int fno = Integer.parseInt(request.getParameter("flightno"));
	        String src = request.getParameter("source");
	        String dest = request.getParameter("destination");
	        String date = request.getParameter("date");
	        String time = request.getParameter("time");
	        int cost = Integer.parseInt(request.getParameter("cost"));
	        
			Flight f = Flight.getFlight(fno, conn);
			Trip t = new Trip(no, src, dest, date, time, f, cost);
			boolean addtrip = currentadmin.addTrip(t, conn);
			if(addtrip)
			{
				request.setAttribute("addTrip", true);
			}
			else {
				request.setAttribute("addTrip", false);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminpage.jsp");
		    dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminlogin.jsp");
		    dispatcher.forward(request, response);
		}
	}

}
