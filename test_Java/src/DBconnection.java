package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBconnection {
	public static void main (String[] Args) throws SQLException, ClassNotFoundException {
		
		//Step1 : define  class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//step 2 : Establish conn
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=redbus;integratedSecurity=true;" ,"sa", "hbs");
		                                               
	    
		// statement for writing query 
		Statement st = conn.createStatement();
		
	   //executeQuery  returns result set
		ResultSet rs = st.executeQuery("Select * from TicketCheck");
		
		List ExpectedList = new ArrayList();
		
		while(rs.next()) {
			System.out.println();
			
			//System.out.println(rs.getString(1) + "::::" + rs.getString(2)  + "::::" + rs.getString(3) + "::::" + 
			//	               rs.getString(4) + "::::" + rs.getString(5)  + "::::" + rs.getString(6) + "::::" + rs.getString(7) );
			
			ExpectedList.add(rs.getString(1) + "::::" + rs.getString(2)  + "::::" + rs.getString(3) + "::::" + rs.getString(4) + "::::" + rs.getString(5)  + "::::" + rs.getString(6) + "::::" + rs.getString(7)  + "\r\n" );
				
		}
		
		System.out.println(ExpectedList);
		
			
			List ActualList = new ArrayList();
			
			
			
	}

} 
