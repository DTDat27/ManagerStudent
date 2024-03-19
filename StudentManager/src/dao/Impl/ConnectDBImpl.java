package testDao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testDao.ConnectDB;
import utils.Constant;

public class ConnectDBImpl implements ConnectDB {

	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet result = null;
	/**
	 * Hàm này để kết nối DB
	 */
	@Override
	public void openConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName(Constant.CLASS_FN);
			this.connection = DriverManager.getConnection(Constant.JDBC_URL, Constant.USER_NAME, Constant.PASSWORD);
			System.out.println("Success connect");
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Lớp BaseRepository -> hàm openConnect lỗi: " + e.getMessage());
        	e.printStackTrace();
        }
	}
	
	@Override
	public Connection getConnection() {
		openConnection();
        return connection;
	}

	/**
	 * Hàm này để đóng kết nối DB
	 */
	@Override
	public void closedConnection() {
		try {
			 if(connection != null && !connection.isClosed()) {
				 connection.close();
				 System.out.println("Đã ngắt kết nối đến DB");
			 }
		} catch (SQLException e) {
			System.err.println("Lớp BaseRepository -> hàm closeConnect lỗi: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
