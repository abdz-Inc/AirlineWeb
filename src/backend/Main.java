package backend;
import java.util.*;
import java.sql.*;

public class Main {

	public static Connection createConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
			  "jdbc:mysql://aws.connect.psdb.cloud/airlinedb?sslMode=PREFERRED",
			  "fdaazqpp28s8qefghivi",
			  "pscale_pw_aRUPpeQTdNeQWahYFcbFAwTDcmEMUpZ5ZM1fVEMPLq");

			
//			int uid = 110;
//			String name = "admin1";
//			String password = "qazwsxedcrfv";
//			String gmail = "admin1@gmail.com";
//			long phn = 8903276529L;
//			
//			User us = new User(uid, password, name, gmail, phn);
//			
//			User u = User.login(gmail, password, conn);
//			System.out.println(u.getUid());
			
			
//			Admin a = Admin.login("rootadmin@gmail.com", "qwertyuiop", conn);
//			Admin ad = new Admin(uid, password, name, gmail, phn);
//			a.addAdmin(ad, conn);
			
//			Flight f1 = new Flight(601, "boeingv1", 60);
//			Flight f2 = new Flight(602, "spicejet", 60);
//			
//			a.addFlight(f1, conn);
//			a.addFlight(f2, conn);
			
//			a.removeFlight(602, conn);
			
//			Flight f3 = Flight.getFlight(601, conn);
//			System.out.println(f3.getName());
//			Trip t1 = new Trip(1, "TPY", "CHE", "2023-06-02", "12:00", f3,10000);
//			Trip t2 = new Trip(2, "CHE", "TPY", "2023-06-03", "12:00", f3,20000);
//			a.addTrip(t1, conn);
//			a.addTrip(t2, conn);
//			a.removeTrip(2, conn);
//			Trip t3 = Trip.getTrip(1, conn);
//			System.out.println(t3.getDate());
//			ArrayList<Trip> trips = Trip.getTrip("TPY", "CHE","2023-06-02", "12:00", conn);
//			for(Trip t3 : trips) {
//				System.out.println(t3.getDate());
//			}
//			trips = Trip.getTrip("2023-06-03", "12:00", conn);
//			for(Trip t3 : trips) {
//				System.out.println(t3.getDate());
//			}
//			BookTicket b1 = BookTicket.bookTicket(101, 2, 2, conn);
//			BookTicket b2 = BookTicket.bookTicket(119, 1, 1, conn);
//			BookTicket b3 = BookTicket.bookTicket(13, 2, 1, conn);
			
//			ArrayList<BookTicket> bookings =BookTicket.viewBookings(13, conn);
//			for(BookTicket bk : bookings)
//			{
//				System.out.println(bk.getTripid()+" "+bk.getNoofseats());
//			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}
