package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		/*
		 * 문제3) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에서 별명의 길이가 제일 긴 별명을 출력하는 프로그램을 작성하시오.
		 * (단, 입력할 때 각 별명의 길이가 같을 수 있다. 작성 클래스명 : ArrayListTest04)
		 */

		Scanner sc = new Scanner(System.in);
		ArrayList<String> nicknames = new ArrayList<String>();

		System.out.println("길이가 같아도 되는 별명 5개 입력:");
		for (int i = 0; i < 5; i++) {
			String nickname = sc.nextLine();
			nicknames.add(nickname);
		}
		int maxlength = nicknames.get(0).length();
		
		for (int i=1;i < nicknames.size();i++) {
			if (nicknames.get(i).length() > maxlength) {
				maxlength = nicknames.get(i).length();
			}
		}
		for (int i = 0; i < nicknames.size(); i++) {
			if(maxlength == nicknames.get(i).length()) {
				System.out.println(nicknames.get(i));
			}
		}

		System.out.println("가장 긴 별명들 : " + maxlength);
	}
	
	// 스택 후입 선출 : 늦게 들어간 데이터가 먼저 나옴

}
