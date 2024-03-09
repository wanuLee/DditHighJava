package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드가 수행되는 시간을 체크해보자
		Thread th = new Thread(new MyRunner02());

		// 1970년 1월 1일 0시 0분 0초 부터 경과한 시간을
		// 밀리세컨드(1/1000) 단위로 반환
		long startTime = System.currentTimeMillis();

		th.start();

		try {
			th.join(); // 현재 위치에서 대상이 되는 쓰레드(변수 th)가
					   // 끝날 때까지 기다린다.

		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();

		System.out.println("경과시간 : " + (endTime - startTime));
	}
}

class MyRunner02 implements Runnable {
	@Override
	public void run() {
		long sum = 0L;

		for (long i = 1L; i <= 1_000_000_000L; i++) {// _는 무시해서 긴 자릿수의 숫자에서 사용
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}