package backend;

import java.util.*;
import java.sql.*;

public class BookTicket {
	
	private int bookid;
	private int uid;
	private int tripid;
	private int amount;
	private int noofseats;
	private int seats[];
	
	public BookTicket(int bookid, int uid, int tripid, int amount, int noofseats) {
		super();
		this.bookid = bookid;
		this.uid = uid;
		this.tripid = tripid;
		this.amount = amount;
		this.noofseats = noofseats;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}
	
	public static BookTicket bookTicket(int uid, int tripid, int noofseats, Connection conn)
	{
		Trip t = Trip.getTrip(tripid, conn);
		if(t.seatsAvailable(noofseats))
		{
			t.fillSeats(noofseats);
			int cost = t.getCostperseat() * noofseats;
			try {
				
				Statement bookstmt = conn.createStatement();
				String qinsert = "insert into bookticket(uid, tripid, amount, noseats) values("+uid+", "+tripid+", "+cost+","+noofseats+");";
				String qselect = "Select * from bookticket where uid = "+uid+" and bookid = (Select max(bookid) from bookticket);";
				bookstmt.executeUpdate(qinsert);
				
				ResultSet rs = bookstmt.executeQuery(qselect);
				rs.next();
				return new BookTicket(rs.getInt("bookid"), rs.getInt("uid"), rs.getInt("tripid"), rs.getInt("amount"), rs.getInt("noseats"));
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				
			}
		}
		return null;
	}
	
	public static ArrayList<BookTicket> viewBookings(int uid, Connection conn)
	{
		
		ArrayList<BookTicket> bookings = new ArrayList<BookTicket>();
		
		try {
			
			Statement bookstmt = conn.createStatement();
			String qselect = "Select * from bookticket where uid = "+uid+";";
			ResultSet rs = bookstmt.executeQuery(qselect);
			while(rs.next()) {
				bookings.add(new BookTicket(rs.getInt("bookid"), rs.getInt("uid"), rs.getInt("tripid"), rs.getInt("amount"), rs.getInt("noseats")));
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		
		return bookings;
	}
	
	public boolean cancelTicket(Connection conn)
	{
		try {
			
			Statement cancelticketstmt = conn.createStatement();
			String q = "delete from bookticket where bookid = "+this.bookid+";";
			System.out.println(q);
			cancelticketstmt.executeUpdate(q);
			
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return false;
		
		}
		return true;
	}
	
}
