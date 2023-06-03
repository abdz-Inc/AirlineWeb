

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

/**
 * Servlet implementation class FlightServlet
 */
@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Admin currentadmin = (Admin) session.getAttribute("admin");
		
		if(currentadmin!= null)
		{
			Connection conn = Main.createConnection();
			int no = Integer.parseInt(request.getParameter("flightno"));
			String name = request.getParameter("flightname");
//	        String src = request.getParameter("source");
//	        String dest = request.getParameter("destination");
	        int seats = Integer.parseInt(request.getParameter("seats"));
	        
			Flight f = new Flight(no, name, seats);
			boolean addflight = currentadmin.addFlight(f, conn);
			if(addflight)
			{
				request.setAttribute("addFlight", true);
			}
			else {
				request.setAttribute("addFlight", false);
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
