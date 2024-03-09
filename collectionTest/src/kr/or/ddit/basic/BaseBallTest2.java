package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest2 {
	private ArrayList<Integer> numList;
	private ArrayList<Integer> userList=
			new ArrayList<Integer>();
	private Scanner scan = new Scanner(System.in);
	
	private int strike;
	private int ball;
	
	public static void main(String[] args) {
		new BaseBallTest2().gameStart();
		
	}
	public void gameStart() {
		//난수르 만드느 메서드
		createNum();
		
		//확인용 출력
//		System.out.println("컴퓨터의 난수값 ==> "+numList);
		
		int cnt =0;//시도 횟수
		do {
			cnt++;
			//사용자로부터 입ㅂ력받기
			inputNum();
			
			//볼카운트를 처리하는 메서드호출
			ballCount();
		}while(strike!=3);// 3스트라이크가 될때까지 반복
		
		System.out.println();
		System.out.println("축하합니다. 당신은 "+cnt+"번째만에 맞췄습니다.");
		
	}
	private void createNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		while(numSet.size()<3) {
			numSet.add((int)(Math.random()*9+1));
		}
		
		numList = new ArrayList<Integer>(numSet);
		
		Collections.shuffle(numList);
	}
	
	// 사용자로부터 3개의 정수를입력받아서 List에 저장하는 메서드
	// 입력한 정수들은 중복되지 않게 한다.
	private void inputNum() {
		int n1,n2,n3;
		do {
			System.out.println("숫자입력 >>");
			
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
		if(n1==n2 ||n1==n3 ||n2 ==n3) {
			System.out.println("중복되는 값은 입력할 수 없습니다. 다시입력하세요");
		}
		}while(n1==n2 ||n1==n3 ||n2 ==n3);
		
		//입력받은 값들을  List에 추가한다.
		userList.clear();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
	}
	private void ballCount() {
		strike = 0;
		ball = 0;
		
		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				if(numList.get(i) == userList.get(j)) {
					if(i==j) {
						strike++;
					}else {
						ball++;
					}
					break;
				}
			}
		}
		
		//볼카운트 결과출력하기
		System.out.printf("%d %d %d ==> %dS %dB\n",
				userList.get(0),userList.get(1),userList.get(2),strike,ball);
		
	}
}
