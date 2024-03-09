package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
 * 	  이 ArrayList에 저장된 데이터들 중에서 '김'씨 성의 이름을 모두 출력하는 프로그램을 작성
 * 	 (단, 입력은 Scanner 이용)
 * 
 */

public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> arr = new ArrayList<String>();

		System.out.println("5명의 이름을 입력하세요:");
		for (int i = 0; i < 5; i++) {
			String name = scanner.nextLine();
			arr.add(name);
		}

		System.out.println("'김'씨 성의 이름 목록:");
		for (int i=0; i<arr.size(); i++) {
//			if (arr.get(i).substring(0,1).equals("김")) {
//				System.out.println(arr.get(i));
//			}
			
			
		}
	}
}
