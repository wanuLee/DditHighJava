package myScheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloWorldScheduler {

	public static void main(String[] args) throws SchedulerException {
		// 1. 스케줄러 생성
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// StdSchedulerFactory클래스의 getDefaultScheduler() 메서드를 사용하여 기본 스케줄러를 가져와서 생성

		// 2. 작업(Job) 생성
		JobDetail job = JobBuilder.newJob(HelloWorldJob.class).withIdentity("helloJob", "group1").build();
		// HelloWorldJob 클래스의 새 작업 인스턴스를 만듭니다
		// .withIdentity("helloJob", "group1"): 작업에 고유한 식별자(이름, 그룹)를 할당합니다.
		// build() - JobDetail반환해주는 메서드 / 즉, 작업 생성

		// 3. 트리거(Trigger) 생성 - 매 초마다 실행
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(6).repeatForever()).build();
		// Trigger trigger = TriggerBuilder.newTrigger(): 트리거(Trigger)를 정의합니다.
		// .withIdentity("helloTrigger", "group1"): 트리거에 고유한 식별자를 할당합니다.
		// .startNow(): 트리거를 즉시 시작하도록 설정합니다.
		// .withSchedule(SimpleScheduleBuilder.simpleSchedule(): 간단한 스케줄을 사용하여 트리거의 실행을
		// 정의합니다.
		// .withIntervalInSeconds(1): 1초마다 실행하도록 간격을 설정합니다.
		// .repeatForever()): 영원히 반복하도록 설정합니다.
		// .build(): 트리거를 생성합니다.

		// 4. 작업(Job)과 트리거(Trigger)를 스케줄러에 등록
		scheduler.scheduleJob(job, trigger);

		// 5. 스케줄러 실행
		scheduler.start();
		System.out.println("-------------- 스케줄러 시작 --------------");

		// 5초동안 메인쓰레드를 중지하여 작업실행
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 스케줄러 종료
		scheduler.shutdown(true);
		System.out.println("-------------- 스케줄러 종료 --------------");

	}
}