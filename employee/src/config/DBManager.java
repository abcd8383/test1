package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DBManager {
	private static DBManager instance = new DBManager();
	private Connection conn;
	
	public DBManager() {
		try {
			//db 접속을 하고 connection을 하나 초기화 
			Class.forName(DBConfig.DB_DRIVER);
			conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PASS);
			//auto commit 비 활성화
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBManager getInstance() {
		if(instance == null)
			instance= new DBManager();
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
}












