

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

import backend.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String src = request.getParameter("source");
		String dest = request.getParameter("destination");
		String date = request.getParameter("date");
		String time = ((String) request.getParameter("time")).length() == 8?request.getParameter("time"):((String) request.getParameter("time")) == ""?"":request.getParameter("time")+":00";
		
		Connection conn = Main.createConnection();
		
		ArrayList<Trip> trips = null;
		if(src == "" || dest == "")
		{
			if(time == "")
			{
				trips = Trip.getTrip(date, conn);
			}
			else{
				trips = Trip.getTrip(date, time, conn);
			}
		}
		else {
			trips = Trip.getTrip(src, dest, date, time, conn);
		}
		request.setAttribute("hasSearched", true);
		if(trips==null) {
			request.setAttribute("hasNoResult", true);
		}
		else {
			request.setAttribute("hasNoResult", false);
		}
		request.setAttribute("trips", trips);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mainpage.jsp");
	    dispatcher.forward(request, response);
	}

}
