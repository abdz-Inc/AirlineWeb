package backend;

import java.util.*;
import java.sql.*;

public class User {
	//variables
	private int uid;
	private String name;
	private String password;
	private String gmail;
	private long phn;
	
	public User(String password, String name, String gmail,  long phn)
	{
		setName(name);
		setPassword(password);
		setGmail(gmail);
		setPhn(phn);
	}
	
	public User(int uid,String password, String name, String gmail,  long phn)
	{
		setUid(uid);
		setName(name);
		setPassword(password);
		setGmail(gmail);
		setPhn(phn);
	}
	
	//getters
	public int getUid() {
		return uid;
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
	public void setUid(int uid) {
		this.uid = uid;
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
	
	public static User login(String gmail, String password, Connection conn)
	{
		try {
			
			Statement loginstmt = conn.createStatement();
			String q = "select * from userinfo;";
			ResultSet rs = loginstmt.executeQuery(q);
			
			while(rs.next())
			{
				if(rs.getString("gmail").equals(gmail) && rs.getString("pas").equals(password))
				{
					System.out.println("here");
					return new User(rs.getInt("uid"), rs.getString("pas"), rs.getString("name"), rs.getString("gmail"), rs.getLong("phnno"));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	public boolean signup(Connection conn)
	{
		try {
			
			Statement signupstmt = conn.createStatement();
			String qinsert = "insert into userinfo(pas, name, gmail, phnno) values('"+password+"', '"+name+"', '"+gmail+"', "+phn+");";

			String qselect = "Select * from userinfo where uid = (Select max(uid) from userinfo);";
			System.out.println(qinsert);
			signupstmt.executeUpdate(qinsert);
			ResultSet rs = signupstmt.executeQuery(qselect);
			rs.next();
			this.setUid(rs.getInt("uid"));
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return false;
		
		}
		return true;
	}
}
