package myScheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AtFixedRate {
	
	public static void main(String[] args) {
		ScheduledJob1 job = new ScheduledJob1(); // 객체 생성
		Timer jobScheduler = new Timer(); 		 // jobScheduler를 초기화

		// 지정한 작업, 일정 시간이 지난 후, 일정 간격
		jobScheduler.scheduleAtFixedRate(job, 1000L, 3000); // 지정한 작업이 실행은 됐지만 1초 지연된 후 3초 간격으로 실행
		jobScheduler.schedule(job, 1000L, 3000); // 지정한 작업이 1초 뒤 시작 3초 간격으로 실행

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		jobScheduler.cancel();
	}
}

/*
 * 주기적인 작업을 수행하는 기능을 구현하기 위해 Timer와 TimerTask클래스를 사용 
 */
class ScheduledJob1 extends TimerTask {
	@Override
	public void run() {
		System.out.println("메일 전송 - " + new Date());
		// run()메서드에서 메일 전송을 나타내는 메시지와 현재 날짜를 출력하는 역할 
	}
}
	
