import java.sql.*;
public class DBConnectioner {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mytestdb?serverTimezone=UTC";
	private static final String DATABASE_USER_NAME = "root";
	private static final String DATABASE_PASSWORD = "anhlong1810";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DATABASE_URL,DATABASE_USER_NAME,DATABASE_PASSWORD);
	}
	
}
