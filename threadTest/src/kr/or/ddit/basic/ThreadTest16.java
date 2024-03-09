package kr.or.ddit.basic;

// 은행의 입출금을 스레드로 처리하는 예제(동기화처리예시)
// 두 명이 같은 계좌에서 동시에 같은 금액을 출금하는 상황
public class ThreadTest16 {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금을 처리하는 메서드
	public void deposit(int money) {
		balance += money;
	}

	// 출금을 처리하는 메서드(반환값 : 출금 성공(true), 출금실패(false)
//	public synchronized boolean withdraw(int money) {
	public boolean withdraw(int money) {
		synchronized (this) {
			if (balance >= money) {
				for (int i = 1; i < 1000000000; i++) {// 시간 지연용
					int k = i + 1;
				}
				balance -= money;
				System.out.println("메서드 안에서 balance = " + balance);
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();
		account.setBalance(10000); // 잔액이 10000원으로 설정

		// 익명 구현체로 쓰레드 구현
		Runnable r = new Runnable() {

			@Override
			public void run() {
				boolean result = account.withdraw(6000); // 6000원 출금
				System.out.println("쓰레드에서 result : " + result + ", balance = " + account.getBalance());
			}
		};

		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);

		th1.start();
		th2.start();
	}
}
