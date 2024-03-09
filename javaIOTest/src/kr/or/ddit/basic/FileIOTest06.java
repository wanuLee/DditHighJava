package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest06 {
	
	 public static void main(String[] args) {
		// Scanner로 출력한 단을 입력 받아 입력 받은 단의 구구단을
		// 'd:/d_other폴더에 'gugudan.txt'파일로 출력하는 프로그램을 작성허시오
		 Scanner scan = new Scanner(System.in);
		 
		 System.out.print("출력할 단 입력 : ");
		 
		 int dan = scan.nextInt();
		 try {
			// 파일 출력용 문자 기반 스트림 객체 생성
			 FileWriter fw =  new FileWriter("d:/d_other/gugudan.txt");
			 
			 for (int i = 1; i <= 9; i++) {
				String str = dan + " * "+ " = "+(dan*i)+"\r\n";
				fw.write(str);
			}
			 
			 System.out.println("출력끝");
			 
			 fw.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		 
	}
}
