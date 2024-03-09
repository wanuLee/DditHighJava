package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC(Java DataBase Connectivity)라이브러리를 이용한 DB자료 처리하기
public class JdbcTest01 {
	/*
	 * JDBC를 이용한 DB자료 처리 순서 1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리로 읽어 들이는 작업
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * 2. DB시스템에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다.
	 * DriverMnager.getConnection()메서드를 이용한다.
	 * 
	 * 3. 질의 ==> SQL문장을 DB서버로 보내서 처리한 결과를 얻어온다. (Statement객체나 PreparedStatement객체를
	 * 이용하여 작업한다.)
	 * 
	 * 4. 얻어온 결과 처리하기 1)SQL문이 SELECT문일 경우에는 SELECT한 결과가 ResultSet객체에 저장되어 반환된다 2)
	 * SQL문이 SELECT문이 아닐경우에는(Insert문, DELETE문, UPDATE문 등)에는 정수 갑시 반환된다.(이 정수 값은 실행에
	 * 성공한 레코드 수를 말한다.)
	 * 
	 * 5. 사용한 자원을 반납하기(Connection 객체 , Statement객체, PreparedStatement객체, ResultSet객체
	 * 등...) ==> 각 객체의 close()메서드를 이용한다.
	 */
	

	public static void main(String[] args) {
		// JDBC작업에 필요한 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB시스템에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "lww97", "java");

			// 3. 질의
			// 3-1. SQL문 작성
			String sql = "SELECT * FROM LPROD";

			// 3-2. Statement 객체 생성 ==> Connection객체를 이용하여 생성한다.
			stmt = conn.createStatement();

			// 3-3. SQL문을 DB서버로 보내서 결과를 얻어온다.
			// (실행할 SQL문이 SELECT문이기 때무네 결과가 ResultSet객체에
			// 저장되어 반환된다.)
			rs = stmt.executeQuery(sql);

			// 4. 결과 처리하기 ==> 한레코드식 화면에 출력하기
			// ResultSet객체에 저장된 데이터를 차례로 꺼내오려면
			// 반복문과 next()메서드를 이용한다.

			// ResultSet객체.next() ==> ResultSet객체에서 데이터가 가리키는
			// 포인터를 다읍번째 위치로이동시키고 그 곳에 데이터가 있으면 true,
			// 없으면 false를 반환
			System.out.println("쿼리문 실행 결과");
			while (rs.next()) {
				// 현재 포인터가 가리키는 ResultSet객체의 데이터를 가져와서 처리한다.
				// 데이터를 가져오는 방법
				// 형식1) ResultSet객체.get자료형이름("컬럼명" 또는 "Alias명");
				// 형식2) ResultSet객체.get자료형이름(컬럼번호);==> 컬럼번호는 1부터 시작

				System.out.println("LPROD_ID : " + rs.getInt(1));
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println();
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_GU : " + rs.getString("LPROD_GU"));
				System.out.println();
				System.out.println("LPROD_NM : " + rs.getString(3));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5.자원반납
			if (rs != null)  try {rs.close();}   catch (SQLException e) {}
			if (stmt != null)try {stmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}
}
