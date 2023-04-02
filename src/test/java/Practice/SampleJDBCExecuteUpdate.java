package Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;

		try
		{
		Driver driverRef=new Driver();
		
		//Step 1:register the driver
		DriverManager.registerDriver(driverRef);
		//Step 2:get the connection
		
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db","root","root");

		//Step 3:issue create Statement
		Statement state=con.createStatement();
		//Step 4:execute a query
		String query= "insert into candidateinfo values('Avanish','27','Pune');";
		int result = state.executeUpdate(query);
		
		String query2= "insert into candidateinfo values('Sahil','28','Mysure');";
		int result2 = state.executeUpdate(query2);
		if(result2>=1)
		{
			System.out.println("data added");
		}
		
		ResultSet resul=state.executeQuery("select * from candidateinfo;");
		
		while(resul.next())
		{
			System.out.println(resul.getString(1));
		}
		}
		catch(Exception e)
		{
			//to do :handle exception
		}
		
		finally {
			//Step 5: close the database
			con.close();
			System.out.println("db close");
			
		}
		
	}

}
