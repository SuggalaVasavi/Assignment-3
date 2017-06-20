package db;

import java.sql.Connection;
import java.sql.SQLException;

public class Dbutil {
	 public static void close(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                
	            }
	        }
	    }
}
