package testDao;

import java.sql.Connection;

public interface ConnectDB {
	/**
	 * Hàm này để kết nối DB
	 */
	public void openConnection();
	
	public Connection getConnection();
	/**
	 * Hàm này để đóng kết nối DB
	 */
	public void closedConnection();
}
