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
					${{secrets.HOST_NAME}}//"jdbc:mysql://aws.connect.psdb.cloud/airlinedb?sslMode=PREFERRED",
					,${{secrets.USERNAME}}//"fdaazqpp28s8qefghivi",
			  ,${{secrets.PASSWORD}});//"pscale_pw_aRUPpeQTdNeQWahYFcbFAwTDcmEMUpZ5ZM1fVEMPLq");

			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}
