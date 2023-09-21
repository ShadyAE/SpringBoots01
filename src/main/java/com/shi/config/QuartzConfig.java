package com.shi.config;

import com.shi.job.Myjob01;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail1() {
        return JobBuilder.newJob(Myjob01.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger1() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//每一秒执行一次
                        .withIntervalInSeconds(1)
//永久重复，一直执行下去
                        .repeatForever();
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder)
                .forJob(jobDetail1())
                .build();
    }

    // 每两秒触发一次任务
    @Bean
    public Trigger trigger2() {
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? * "))
                        .forJob(jobDetail1())
                        .build();
    }

}
