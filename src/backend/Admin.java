package backend;

import java.util.*;
import java.sql.*;

public class Admin {
	
	//variables
		private int aid;
		private String name;
		private String password;
		private String gmail;
		private long phn;
		
		public Admin(int aid, String password, String name, String gmail,  long phn)
		{
			setAid(aid);
			setName(name);
			setPassword(password);
			setGmail(gmail);
			setPhn(phn);
		}
		
		//getters
		public int getAid() {
			return aid;
		}
		
		public String getName() {
			return name;
		}
		
		public String getPassword() {
			return password;
		}
		
		public String getGmail() {
			return gmail;
		}
		
		public long getPhn() {
			return phn;
		}
		
		//setters
		public void setAid(int aid) {
			this.aid = aid;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public void setGmail(String gmail) {
			this.gmail = gmail;
		}
		
		public void setPhn(long phn) {
			this.phn = phn;
		}
		
		public static Admin login(String gmail, String password, Connection conn)
		{
			try {
				
				Statement loginstmt = conn.createStatement();
				String q = "select * from admininfo;";
				ResultSet rs = loginstmt.executeQuery(q);
				
				while(rs.next())
				{
					if(rs.getString("gmail").equals(gmail) && rs.getString("pas").equals(password))
					{
						System.out.println("here");
						return new Admin(rs.getInt("aid"), rs.getString("pas"), rs.getString("name"), rs.getString("gmail"), rs.getLong("phnno"));
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return null;
		}
		
		public boolean addAdmin(Admin adm, Connection conn)
		{
			try {
				
				Statement addadminstmt = conn.createStatement();
				String q = "insert into admininfo values("+adm.getAid()+", '"+adm.getPassword()+"', '"+adm.getName()+"', '"+adm.getGmail()+"', "+adm.getPhn()+");";
				System.out.println(q);
				addadminstmt.executeUpdate(q);
				
			}
			catch(Exception e)
			{
				
				System.out.println(e);
				return false;
			
			}
			return true;
		}
		
		public boolean addFlight(Flight f, Connection conn)
		{
			try {
				
				Statement signupstmt = conn.createStatement();
				String q = "insert into flight values("+f.getFlightno()+", '"+f.getName()+"', "+f.getNoseats()+");";
				System.out.println(q);
				signupstmt.executeUpdate(q);
				
			}
			catch(Exception e)
			{
				
				System.out.println(e);
				return false;
			
			}
			return true;
		}
		
		public boolean removeFlight(int flightno, Connection conn)
		{
			try {
				
				Statement signupstmt = conn.createStatement();
				String q = "delete from flight where flightno = "+flightno+";";
				System.out.println(q);
				signupstmt.executeUpdate(q);
				
			}
			catch(Exception e)
			{
				
				System.out.println(e);
				return false;
			
			}
			return true;
		}
		
		public boolean addTrip(Trip t, Connection conn)
		{
			try {
				
				Statement addtripstmt = conn.createStatement();
				String q = "insert into trip values("+t.getTripid()+", '"+t.getSrc()+"', '"+t.getDest()+"', '"+t.getDate()+"', '"+t.getTime()+"', "+t.getFlight().getFlightno()+","+t.getCostperseat()+");";
				System.out.println(q);
				addtripstmt.executeUpdate(q);
				
			}
			catch(Exception e)
			{
				
				System.out.println(e);
				return false;
			
			}
			return true;
		}
		
		public boolean removeTrip(int tripid, Connection conn)
		{
			try {
				
				Statement rmvtripstmt = conn.createStatement();
				String q = "delete from trip where tripid = "+tripid+";";
				System.out.println(q);
				rmvtripstmt.executeUpdate(q);
				
			}
			catch(Exception e)
			{
				
				System.out.println(e);
				return false;
			
			}
			return true;
		}
	
}
