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
public class ThreadTest07 {
	public static boolean inputCheck = false;

	public static void main(String[] args) {
		Timer t = new Timer();

		// 컴퓨터 선택
		String[] data = { "가위", "바위", "보" };
		int index = (int) (Math.random() * 3); // 0 ~ 2
		String com = data[index];

		// 카운트다운 실행
		t.start();

		// 사용자 입력
		String man = null;
		do {
			man = JOptionPane.showInputDialog("가위, 바위, 보를 입력하세요");
//		}while( !("가위".equals(man) || "바위".equals(man) ||"보".equals(man)) );
		} while (!"가위".equals(man) && !"바위".equals(man) && !"보".equals(man));//  !man.equals("문자열")에서 man이 null인 경우 입력 취소 시에 오류
		
		inputCheck = true;

		// 승패 판정
		String result;
//		if (man.equals(com)) {
//			result = "비겼습니다.";
//		} else if (man.equals("가위") && com.equals("보") || 
//				   man.equals("바위") && com.equals("가위")|| 
//				   man.equals("보") && com.equals("바위")) {
//			result = "당신이 이겼습니다.";
//		} else {
//			result = "당신이 졌습니다.";
//		}

		switch (com + man) {
		case "가위가위":
		case "바위바위":
		case "보보":
			result = "비겼습니다.";
			break;
		case "가위바위":
		case "바위보":
		case "보가위":
			result = "님이 이겼습니다.";
			break;

		default:
			result = "님이 졌습니다.";
		}

		// 결과 출력
		System.out.println("-- 결과 --");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결과 : " + result);
	}

}

// 타이머
class Timer extends Thread {
	@Override
	public void run() {
		for (int i = 15; i >= 1; i--) {
			if (ThreadTest07.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-- 결과 --");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}
