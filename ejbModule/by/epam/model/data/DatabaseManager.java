package by.epam.model.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.epam.exception.custom.ConnectionException;

public class DatabaseManager {
	public static Connection getConnection() throws ConnectionException {
		try {
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:/MySqlDS");
			Connection connection = ds.getConnection();
			
			return connection;
		} catch (NamingException | SQLException e) {
			throw new ConnectionException("Database access error", e);
		}
	}
	
	public static void closeResultSet(ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public static void closeStatements(Statement... statements) {
		for (Statement st : statements) {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
	
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
