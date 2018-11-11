package parserforstops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;

public class DBconnector {
	
	private Connection myConn ;
	private Statement stmt;
	ResultSet rs;
	
	public void openconnection() {
	//establishing connection with wampserver 
	try
	{
	    //loading the jdbc driver
	    Class.forName("com.mysql.cj.jdbc.Driver");         
	    //Open a connection
	    System.out.println("Connecting to a selected database... ");
	    //get a connection to database
	    myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/catch_the_bus?useSSL=true&useUnicode="
	    		+ "true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone="+TimeZone.getDefault().getID()+"","root","");
	   
	   
	  }
	  catch(SQLException e)
	  {
	           System.out.println(e);   
	  }
	  catch(Exception e)
	  {
	           
			System.out.println(e);
	    }

	
		
	}
	
	//closes a connection to the wampserver
	private void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		catch (Exception e) {
			
		}
	}
	
	
	public void add_stop(String id,String name){
		openconnection();
		
		try {
			 //create a statement
			stmt = myConn.createStatement();
			//execute sql update
		    stmt.executeUpdate("INSERT INTO `stops` (`id`, `name`) VALUES ('"+ id +"', '"+ name + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}
	
	public void add_bus(String id,String name)
	{
		openconnection();
		try {
			 //create a statement
			stmt = myConn.createStatement();
			//execute sql update
			stmt.executeUpdate("INSERT INTO `buses` (`id`, `name`) VALUES ('"+ id +"', '"+ name + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}

		
	}
	
	public void add_has(String id, String passing_line) {
		openconnection();
		try {
			 //create a statement
			stmt = myConn.createStatement();
			//execute sql update
			stmt.executeUpdate("INSERT INTO `has` (`bus_id`, `stop_id`) VALUES ('"+ id +"', '"+ passing_line + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}

		
	}
	
	
	 String findStopNameByID(String stop_id) {
		openconnection();
		
		try {
			 //create a statement
			stmt = myConn.createStatement();
			//execute querry
			ResultSet rs = stmt.executeQuery("select * from stops where id = '"+stop_id+"'");
			while(rs.next())
				return rs.getString("name") ; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return null ; 
		
		
	}

}
