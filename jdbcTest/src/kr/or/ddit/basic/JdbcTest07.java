package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
   회원을 관리하는 프로그램을 작성하시오.
   (mymember 테이블 이용)
   
   아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현하기) insert select update delete
   
   메뉴 예시)
   == 작업 선택 ==
   1. 자료 추가      ==> insert (C)
   2. 자료 삭제      ==> delete (D)
   3. 자료 수정      ==> update (U)
   4. 전체 자료 출력   ==> select (R)
   0. 작업 끝.
   
   조건)
   1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
   2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
   3) 자료 수정에서 '회원ID'는 변경되지 않는다.
   
 */
public class JdbcTest07 {
	private Scanner scan;
//	private Connection conn = null;
	private Connection conn = DBUtil3.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public static void main(String[] args) {
		new JdbcTest07().memberStart();
	}

	// 생성자
	public JdbcTest07() {
		scan = new Scanner(System.in);
	}

	// 시작메서드
	public void memberStart() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 추가
				insertMember();
				break;
			case 2: // 삭제
				deleteMember();
				break;
			case 3: // 수정
				updateMember();
				break;
			case 4: // 전체 출력
				displayAllMember();
				break;
			case 5: // 원하는 정보만 출력
				updateMember2();
				break;
			case 0: // 작업끝
				System.out.println("프로그램을 마칩니다.");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}

	// 회원 정보를 수정하는 메서드2 ==> 원하는 항목만 수정하기
	private void updateMember2() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원ID >> ");
		String memId = scan.next();

		int count = getMemberCount(memId);

		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 ID 입니다...");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}

		System.out.println("===수정할 항목을 고르세요===");
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 주소 수정");

		int num;
		String fieldName = null;
		String msg = null;

		do {
			System.out.println();
			System.out.println("수저아할 항목을 선택하세요...");
			System.out.println("1. 비밀번호   2. 회원이름    3.전화번호   4.회원주소");
			System.out.println("----------------------------------------");
			System.out.println("수정할 항목 선택");
			num = scan.nextInt();

			switch (num) {
			case 1:
				fieldName = "mem_pass";
				msg = "비밀번호";
				break;
			case 2:
				fieldName = "mem_name";
				msg = "회원이름";
				break;
			case 3:
				fieldName = "mem_tel";
				msg = "전화번호";
				break;
			case 4:
				fieldName = "mem_addr";
				msg = "회원주소";
				break;
			default:
				System.out.println("수정항목을 찾지 못했습니다. 다시 선택하세요");
				return;
			}
		} while (num < 1 || num > 4);

		// 수정할 값을 입력 받기
		scan.nextLine();// 입력 버퍼 비우기
		System.out.println("새로운" + msg + ">>");
		String updateData = scan.nextLine();

		try {
			conn = DBUtil.getConnection();

			String sql = "update mymember set " + fieldName + " = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "회원의 " + msg + " 항목 수정 완료");
			} else {
				System.out.println(memId + "회원정보 수정 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}

		}

	}

	// 회원 정보를 수정하는 메서드
	private void updateMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원ID >> ");
		String memId = scan.next();

		int count = getMemberCount(memId);

		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 ID 입니다...");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}

		System.out.print("새로운 비밀번호 >> ");
		String newPass = scan.next();

		System.out.print("새로운 이름 >> ");
		String newName = scan.next();

		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();

		scan.nextLine(); // 버퍼 비우기
		System.out.print("새로운 주소 >> ");
		String newAddr = scan.nextLine();

		try {
			conn = DBUtil.getConnection();

			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newPass);
			pstmt.setString(2, newName);
			pstmt.setString(3, newTel);
			pstmt.setString(4, newAddr);
			pstmt.setString(5, memId);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + " 회원 정보 수정 완료!!!");
			} else {
				System.out.println(memId + " 회원 정보 수정 실패!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}

	// 전체 회원 정보를 출력하는 메서드
	private void displayAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("-----------------------");
		System.out.println("회원ID\t비밀번호\t이름\t전화번호\t\t주소");

		try {
//			conn = DBUtil.getConnection();
//			conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getNString("mem_id");
				String pass = rs.getNString("mem_pass");
				String name = rs.getNString("mem_name");
				String tel = rs.getNString("mem_tel");
				String addr = rs.getNString("mem_addr");

				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}

	// 회원 정보를 삭제하는 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요...");
		System.out.print("삭제할 회원ID >> ");

		String memId = scan.next();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + " 회원 정보 삭제 완료!!");
			} else {
				System.out.println(memId + " 회원은 없는 회원이거나 삭제 작업을 실패했습니다...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}

	// 회원 정보를 추가하는 메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");

		int count = 0;
		String memId = null;

		do {
			System.out.print("회원ID 입력 >> ");
			memId = scan.next();

			count = getMemberCount(memId);

			if (count > 0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
			}

		} while (count > 0);

		System.out.print("비밀번호 >> ");
		String memPass = scan.next();

		System.out.print("이름 >> ");
		String memName = scan.next();

		System.out.print("전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine(); // 입력 버퍼 지우기
		System.out.print("주소 >> ");
		String memAddr = scan.nextLine();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBUtil.getConnection();

			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) "
					+ " values (?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "회원 정보 추가 성공!!");
			} else {
				System.out.println(memId + "회원 정보 추가 실패!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}

	// 회원 ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		int count = 0; // 반환값이 저장될 변수

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
//            count = rs.getInt(1);
				count = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return count;
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("== 작업 선택 ==");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 원하는 자료 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("========= ==");
		System.out.print("원하는 작업 선택 >> ");
		return scan.nextInt();
	}
}