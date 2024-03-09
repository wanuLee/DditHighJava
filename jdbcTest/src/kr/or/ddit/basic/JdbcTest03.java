package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) LPRD_id값을 2개 입력 받아서 두 값 중 작은 값부터
// 		큰값 사이의 자료들을 출력하시오

public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		

		System.out.println("원하는 구간의 상품번호를 작은 순서대로 입력하세요");
		System.out.print("1구간 : ");
		int num1 = scan.nextInt();
		
		System.out.print("2구간 : ");
		int num2 = scan.nextInt();
		
		
		// 쿼리1 적용시
		if(num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "lww97", "java");

//			// 쿼리1 (num1이 크면 실행이 안댐...)
//			String sql = ("SELECT * FROM LPROD WHERE (LPROD_ID >= " + num1 +" AND LPROD_ID <=" + num2 + ")");
//
//			// 쿼리2
////			String sql;
////			if (num1 < num2) {
////				sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN " + num1 + " AND " + num2;
////			} else {
////				sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN " + num2 + " AND " + num1;
////				System.out.println("작은 순서대로 입력하자~");
////				System.out.println();
////			}
//
//			stmt = conn.createStatement();
//
//			rs = stmt.executeQuery(sql);

			String sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN ?  AND ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num1);
			pstmt.setInt(2, num2);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " + rs.getString("LPROD_GU"));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}
}
