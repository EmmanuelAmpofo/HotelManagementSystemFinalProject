import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class hotelDbConnection {
	static Connection connection ;
	
	
	public static  Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Poff\\eclipse-workspace\\HotelManagementSystem\\src\\database\\hoteldata");
			
			return connection;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	

}
