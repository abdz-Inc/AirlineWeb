package backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Flight {
	private int flightno;
	private String name;
	private int noseats;
	
	
	public int getFlightno() {
		return flightno;
	}
	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNoseats() {
		return noseats;
	}
	public void setNoseats(int noseats) {
		this.noseats = noseats;
	}
	
	
	
	public Flight(int flightno, String name, int noseats) {
		super();
		setFlightno(flightno);
		setName(name);
		setNoseats(noseats);
	}
	public static Flight getFlight(int flightno, Connection conn)
	{
		try {
			
			Statement getflightstmt = conn.createStatement();
			String q = "select * from flight where flightno = "+flightno+";";
			
			ResultSet rs = getflightstmt.executeQuery(q);
			rs.next();
			
			return new Flight(rs.getInt("flightno"), rs.getString("name"), rs.getInt("noofseats"));
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return null;
		
		}
		
	}
	
}
