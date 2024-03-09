package myScheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.TimeZone;

import org.quartz.Trigger;

public class Cron {

    public static void main(String[] args) {

        // 매일 8 ~ 17시 사이 2분마다 작동
        Trigger trigger1 = newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0 0/2 8-21 * * ?")).forJob("myJob", "group1").build();
        

        // 매일 10시 42분에 작동
        Trigger trigger2 = newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(cronSchedule("0 42 10 * * ?")).forJob("myJob", "group1").build();

        // 매주 수요일 10시 42분에 작동
        Trigger trigger3 = newTrigger().withIdentity("trigger3", "group1")
                .withSchedule(cronSchedule("0 42 10 ? * WED").inTimeZone(TimeZone.getTimeZone("America/Los_Angeles")))
                .forJob("myJob", "group1").build();

    }

}