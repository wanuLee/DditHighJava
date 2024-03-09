package myScheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

// Job: 실제로 수행될 작업의 내용을 정의합니다. execute() 메소드가 오버라이드 되어야 하며, 스케줄러가 이 메소드를 호출하여 작업을 실행합니다
public class HelloWorldJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 작업 실행 시 출력할 내용
        System.out.println("Quartz Test!");
    }
}
