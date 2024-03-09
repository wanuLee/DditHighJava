package kr.or.ddit.basic;

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();

		TestThread th1 = new TestThread("1번 쓰레드", sObj);
		TestThread th2 = new TestThread("2번 쓰레드", sObj);

		th1.start();
		th2.start();

	}
}

class ShareObject {
	private int sum = 0;

	// 동기화 처리(synchronized)
//	public synchronized void add() {// 방법 1 ==> 메서드에 동기화 설정하기
	public void add() {// 방법 2
		synchronized (this) {
			int n = sum;

			n += 10; // 10 증가

			sum = n;

			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
}

class TestThread extends Thread {
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name); // 쓰레드의 name설정
		this.sObj = sObj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObj.add();
		}
	}
}