package pe.quatu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConn {
	
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/BDQUATU";
	private static final String USER = "root";
	private static final String PASSWORD = "chapulin";

	public static Connection getConnection() {
		
		Connection cn = null;

		try {
			Class.forName(DRIVER_CLASS);

			cn = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cn;
	}
}
