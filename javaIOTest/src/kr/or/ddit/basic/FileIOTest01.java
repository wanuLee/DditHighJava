package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		// FileInputStream객체를 이용한 파일 내용 읽기
		try {
			// 읽어올 파일 정보를 갖는 파일 입력용 스트림 객체를 생성한다.

			// 방법 1 읽어올 파일 정보를 문자열로 지정하는 방법
//			FileInputStream fin = new FileInputStream("d:/d_other/text.txt");

			// 방법 2) 읽어올 파일 정보가 저장된 File객체를 지정하는 방법
			File file = new File("d:/d_other/text.txt");
			FileInputStream fin = new FileInputStream(file);

			int c; // 읽어온 데이터가 저장될 변수 선언 // 배열의 중간에 '-1'이 있으면 반복문의 실행에 지장을 주지 않기 위한 방법
			while ((c = fin.read()) != -1) {

				// 읽어온 데이터를 화면에 출력하기
				System.out.print((char) c);
			}
			fin.close();

		} catch (IOException e) {
			System.out.println("입출력 오류입니다.");
		}
	}
}

/*
 * 2의 보수법(음수 출력)
 * => 1의 보수 +1
 * 
 * ex) -25 
 * 	   25 => 00011001(2)
 * 	  -25 => 11100110 + 1 = 11100111(2)	
 *
 * ex) -1
 *	  00000001(2) = 1
 *	  11111110(2) = 1의 보수
 *	  11111111(2) = -1
 */


