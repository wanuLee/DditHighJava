package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 스레드 프로그램

		// Thread를 사용하는 방법

		// ********* 방법1 *********
		// 1) Thread 클래스를 상속한 class를 작성한다.
		// 2) 작성된 class의 인스턴스를 생성한다.(객체생성)
		// 3) 생성된 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread01 th1 = new MyThread01();
		th1.start();

		// ********* 방법2-1 *********
		// 1) Runnable인터페이스를 구현한 class를 작성한다.
		// 2) 작성된 class의 인스턴스를 생성한다.
		// 3) Thread클래스의 인스턴스를 생성할 때 인자값으로
		//	  2번에서 생성한 인스턴스를 주입한다.
		// 4) 3번에서 생성된 Thread클래스의 인스턴스의 start()메서드를
		// 	    호출해서 실행한다.
		MyRunner01 r1 = new MyRunner01(); // 2)
		Thread th2 = new Thread(r1);	  // 3)
		th2.start(); 						  // 4)
		
		// ********* 방법2-2 *********
		// 1) Runnable 인터페이스의 익명 구현체를 작성한다.
		// 2) Thread 클래스의 인스턴스를 생성할 때 1번의 익명 구현체를 주입한다.
		// 3) 2번 인스턴스의 start()메서드를 호출해서 실행한다.
		Runnable r2 = new Runnable() {	  // 1)

			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		Thread th3 = new Thread(r2);
		th3.start();
		
		
		System.out.println("main메서드 끝");
		// 멀티 쓰레드에서는 main메서드도 하나의 쓰레드라서 실행중인 다른 쓰레드도 종료되야 끝
	}
}

// 방법 1
class MyThread01 extends Thread {
	@Override
	public void run() {
		// 이 run()메서드에는 쓰레드가 처리할 내용을 작성하면 된다.
		for (int i = 1; i <= 100; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간); ==> 주어진 시간동안 작업을 잠시 멈춘다
				// 시간은 밀리세컨드 단위를 사용한다.
				// 즉, 1000분의 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
// 방법 2-1
class MyRunner01 implements Runnable {
	@Override
	public void run() {
		// 이 run()메서드에는 쓰레드가 처리할 내용을 작성하면 된다.
		for (int i = 1; i <= 100; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}