package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// JDBC드라이버를 로딩하고 Connection객체를 생성해 반환하는
// 메서드로 구성된 class만들기

// (dbinfo.properties파일 내용을 이용하여 설정하기
// 		==> ResourceBundlde객체 이용하기)

public class DBUtil3 {
	private  static ResourceBundle bundle; //ResourceBundle 객체 변수 선언
	
	
	static {
		//ResourceBundle객체 생성
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo"); 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "lww97", "java");
			conn = DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB연결 실패!!!");
			e.printStackTrace();
		}
		return conn;
	}

}
