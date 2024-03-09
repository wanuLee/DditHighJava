package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

// Statement 객체를 사용했을 때 SQL Injection 해킹에 노출되는 예제
public class JdbcTest06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			System.out.println(" == 계좌 정보 검색하기 == ");
			System.out.println("검색할 계좌번호 입력 >> ");
			String bankNo = scan.nextLine();

			// Statement 객체를 이용한 처리
//			String sql = "select * from bankinfo where bank_no = '" + bankNo + "'";
//
//			System.out.println("SQL문장 : " + sql);
//
//			stmt = conn.createStatement();
//
//			rs = stmt.executeQuery(sql);
			
			// PreparedStatement 객체를 이용한 처리
			String sql = "select * from bankinfo where bank_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bankNo);
			
			rs = pstmt.executeQuery();
					

			System.out.println(" == 검색 결과 ==");
			System.out.println("계좌번호\t\t은행명\t예금주명\t\t개설날짜");
			System.out.println("------------------------------------------------------------------");
			while (rs.next()) {
				String bNo = rs.getString("bank_no");
				String bName = rs.getString("bank_name");
				String uName = rs.getString("bank_user_name");
				String bDate = rs.getString("bank_date");
				System.out.println(bNo + "\t" + bName + "\t" + uName + "\t\t" + bDate);
			}

			/*
			 * ' or 1=1 -- 이렇게 입력하면 모든 정보 다 나옴 select * from bankinfo where bank_no = '' or 1=1 -- '
			 * 
			 * 'union select mem_id, mem_pass, mem_name,null from member --
			 *    -- 모든 멤버를 조회
			 */
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
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
