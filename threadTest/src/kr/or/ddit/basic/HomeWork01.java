package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오
 * 컴퓨터의 가위바위보는 난수를 이용해서 구하고, 
 * 사용자의 입력은 showInputDialog()메서드를 이용해서 입력받는다
 * 입력시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 5초 안에 입력이 없으며 게임에 진 것으로 처리하고 프로그램을 끝낸다.
 * 
 * 5초안에 입력이 완료되면 컴퓨터와의 승패를 구해서 출력한다.
 * 
 * 결과예시)
 * 1) 5초안에 입력을 못했을때
 * 
 * --결과 --
 * 시간 초과로 당신이 졌습니다.
 * 
 * 2) 5초안에 입력했을때
 * 
 * -- 결과 --
 * 컴퓨터 : 가위
 * 사용자 : 바위
 * 결과 : 당신이 이겼습니다.
 */
public class HomeWork01 {
	public static boolean inputcheck;

	public static void main(String[] args) {
		GameTimer gt = new GameTimer();

		// 난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = { "가위", "바위", "보" };
		int index = (int) (Math.random() * 3); // 0~2사이의 난수 만들기
		String com = data[index];

		// 사용자로부터 가위바위보 입력 받기
		gt.start();
		String man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
		inputcheck = true;

		String result = ""; // 결과가 저장될 변수
		if (man.equals(com)) {
			result = "비겼습니다.";
		} else if (man.equals("가위") && com.equals("보") || man.equals("바위") && com.equals("가위")
				|| man.equals("보") && com.equals("바위")) {
			result = "당신이 이겼습니다.";
		} else {
			result = "당신이 졌습니다.";
		}

		// 결과 출력
		System.out.println("-- 결과 --");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결   과 : " + result);

	}
}

//카운트다운을 시작하는 쓰레드
class GameTimer extends Thread {
	@Override
	public void run() {
		System.out.println("카운트다운 시작");

		for (int i = 15; i >= 1; i--) {
			if (HomeWork01.inputcheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}

			System.out.println();
			System.out.println("--결과--");
			System.out.println("시간초과로 당신이 졌습니다.");
			System.exit(0);
		}
	}
}
