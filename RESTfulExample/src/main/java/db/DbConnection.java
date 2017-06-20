package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*public class DbConnection {
public static Connection getConnection()
{
	Connection connection=null;
try
{
String connectionURL = "jdbc:mysql://localhost:3306/form";
Class.forName("com.mysql.jdbc.Driver").newInstance();

connection = DriverManager.getConnection(connectionURL, "root", "1234");
}
catch (Exception e)
{
System.out.println(e);
e.printStackTrace();
}
return connection;
}
} */
public class DbConnection {

	private static DbConnection instance = new DbConnection();
	private static final String url = "jdbc:mysql://localhost:3306/form";

	private static final String username = "root";

	private static final String password = "1234";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

 public DbConnection(){
	try{
		Class.forName(DRIVER_CLASS);
	}catch (ClassNotFoundException e) {
        e.printStackTrace();
}
}
public Connection createConnection(){
	Connection connection=null;
	try
	{
		connection = DriverManager.getConnection(url,username,password);
	}
	 catch (SQLException e) {
         System.out.println("ERROR: Unable to Connect to Database.");
     }
     return connection;
 }

	public static Connection getConnection()
	{
	return instance.createConnection();
	}

}