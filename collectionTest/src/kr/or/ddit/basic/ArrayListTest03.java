package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		/*
		 * 문제2) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에서 별명의 길이가 제일 긴 별명을 출력하는 프로그램을 작성하시오.
		 * (단, 입력할 때 각 별명의 길이를 다르게 입력한다. 작성 클래스명 : ArrayListTest03)
		 */

		Scanner scanner = new Scanner(System.in);
		ArrayList<String> nicknames = new ArrayList<String>();

		System.out.println("서로 다른 길이의 별명 5개를 입력하세요:");
		for (int i = 0; i < 5; i++) {
			String nickname = scanner.nextLine();
			nicknames.add(nickname);
		}
		String longestNickname = "";
	    for (String nickname : nicknames) {
	        if (nickname.length() > longestNickname.length()) {
	            longestNickname = nickname;
	        }
	    }

	    System.out.println("가장 긴 별명 : " + longestNickname);
	}
}
