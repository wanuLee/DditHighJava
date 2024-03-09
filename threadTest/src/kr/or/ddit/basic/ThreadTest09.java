package kr.or.ddit.basic;

// 쓰레드의 상태를 출력하는 예제
public class ThreadTest09 {

	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		th.start();
	}
}

//쓰레드 상태의 감시 대상이 된느 쓰레드
class TargetThread extends Thread {

	@Override
	public void run() {
		for (long i = 1L; i < 20_000_000_000L; i++) {
			long k = i + 1;
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		for (long i = 1L; i < 20_000_000_000L; i++) {
			long k = i + 1;
		}
	}
}

// TargetThread의 상태값을 구해서 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;

	public StatePrintThread(TargetThread target) {
		this.target = target;
	}
	@Override
	public void run() {
		while(true) {
			// TargetThread의 상태값을 구하기
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상탯값 : "+state);
			
			if(state == Thread.State.NEW) {// 스레드의 상태가 NEW이면...
				target.start();
			}
			if(state == Thread.State.TERMINATED) { // 쓰레드의 상태가 종료 상태이면...
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
