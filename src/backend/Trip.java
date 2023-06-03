package backend;

import java.util.*;
import java.sql.*;

public class Trip {
	private int tripid;
	private String src;
	private String dest;
	private String date;
	private String time;
	private Flight flight;
	private boolean seats[];
	private int costperseat;
	private int lastindex = 0;

	public Trip(int tripid, String src, String dest, String date, String time, Flight flight,int cost) {
		super();
		this.tripid = tripid;
		this.src = src;
		this.dest = dest;
		this.date = date;
		this.time = time; 
		this.flight = flight;
		this.costperseat = cost;
		
		if(this.flight != null)
		{
			seats = new boolean[this.flight.getNoseats()];
			Arrays.fill(seats, false);
		}
		
	}
	
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public int getCostperseat() {
		return costperseat;
	}

	public void setCostperseat(int costperseat) {
		this.costperseat = costperseat;
	}

	public boolean seatsAvailable(int noofseats)
	{
		System.out.println(lastindex);
		if(noofseats + lastindex <=seats.length)
		{
			return true;
		}
		return false;
	}
	
	public void fillSeats(int noofseats)
	{
		for(int i = 0;i<noofseats;i++)
		{
			seats[lastindex] = true;
			lastindex++;
		}
	}
	
	public static Trip getTrip(int tripid, Connection conn)
	{
		try {
			
			Statement getflightstmt = conn.createStatement();
			String q = "select * from trip where tripid = "+tripid+";";
			
			ResultSet rs = getflightstmt.executeQuery(q);
			rs.next();
			
			return new Trip(rs.getInt("tripid"), rs.getString("src"), rs.getString("dest"), rs.getString("date"), rs.getString("time"), Flight.getFlight(rs.getInt("flightno"), conn), rs.getInt("cost"));
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return null;
		
		}
	}

	
	public static ArrayList<Trip> getTrip(String src, String dest, String date, String time, Connection conn)
	{
		try {
			
			Statement gettripstmt = conn.createStatement();
			String q = "select * from trip where src = '"+src+"'and dest = '"+dest+"'and date = '"+date+"'and time = '"+time+"';";
			
			System.out.println(q);
			
			ResultSet rs = gettripstmt .executeQuery(q);
			ArrayList<Trip> trips = new ArrayList<Trip>();
			while(rs.next()) {
				trips.add(new Trip(rs.getInt("tripid"), rs.getString("src"), rs.getString("dest"), rs.getString("date"), rs.getString("time"), Flight.getFlight(rs.getInt("flightno"), conn), rs.getInt("cost")));

			}
			
			return trips;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return null;
		
		}
	}
	
	public static ArrayList<Trip> getTrip(String date, String time, Connection conn)
	{
		try {
			
			Statement gettripstmt = conn.createStatement();
			String q = "select * from trip where date = '"+date+"'and time = '"+time+"';";
			
			System.out.println(q);
			
			ResultSet rs = gettripstmt .executeQuery(q);
			ArrayList<Trip> trips = new ArrayList<Trip>();
			while(rs.next()) {
				trips.add(new Trip(rs.getInt("tripid"), rs.getString("src"), rs.getString("dest"), rs.getString("date"), rs.getString("time"), Flight.getFlight(rs.getInt("flightno"), conn), rs.getInt("cost")));

			}
			
			return trips;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return null;
		
		}
	}
	
	public static ArrayList<Trip> getTrip(String date, Connection conn)
	{
		try {
			
			Statement gettripstmt = conn.createStatement();
			String q = "select * from trip where date = '"+date+"';";
			
			System.out.println(q);
			
			ResultSet rs = gettripstmt .executeQuery(q);
			ArrayList<Trip> trips = new ArrayList<Trip>();
			while(rs.next()) {
				trips.add(new Trip(rs.getInt("tripid"), rs.getString("src"), rs.getString("dest"), rs.getString("date"), rs.getString("time"), Flight.getFlight(rs.getInt("flightno"), conn), rs.getInt("cost")));

			}
			
			return trips;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return null;
		
		}
	}
	
}
