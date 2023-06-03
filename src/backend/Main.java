package backend;
import java.util.*;
import java.sql.*;

public class Main {

	public static Connection createConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}
