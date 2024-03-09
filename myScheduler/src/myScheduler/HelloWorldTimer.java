package myScheduler;

import java.util.Timer;
import java.util.TimerTask;

public class HelloWorldTimer {
    public static void main(String[] args) {
        // Timer 객체 생성
        Timer timer = new Timer();

        // TimerTask를 상속받은 클래스 생성
        HelloWorldTask task = new HelloWorldTask();

        // 예제 1
        // 0초 뒤부터 1초 간격으로 작업을 실행합니다.
//        timer.scheduleAtFixedRate(task, 0, 1000);

        // 예제 2        
        // 1초 후부터 시작하여 2초 간격으로 작업을 실행
        timer.schedule(task, 1000L, 3000);

        System.out.println("-------------- 타이머 시작 --------------");

      // 5초동안 메인쓰레드를 중지하여 작업실행
      try {
         Thread.sleep(20000);
      } catch (Exception e) {
         e.printStackTrace();
      }

      // 타이머 종료
      timer.cancel();
      System.out.println("-------------- 타이머 종료 --------------");
    }
}

// TimerTask를 상속받아 작업을 정의하는 클래스
class HelloWorldTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}