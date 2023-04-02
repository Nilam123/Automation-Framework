package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//jdbc:mysql://localhost:3306/mydb
		
		
		//driver for my database
		Driver driverRef=new Driver();
		//Step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		//Step 2: Get the connection from database -databse name
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db","root","root");
		//Step 3: issue create statement
		Statement state=con.createStatement();
		//step 4:execute a query
		
		ResultSet result=state.executeQuery("select * from candidateinfo");
		while(result.next())
		{
			System.out.println("Name -"+result.getString(1)+ " -Roll Number "+result.getString(2));
		}
		//step 5: close the database
		
		con.close();
	}

}
