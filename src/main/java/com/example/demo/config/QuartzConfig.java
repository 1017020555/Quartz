package com.example.demo.config;

import com.example.demo.job.QuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail(){

        return JobBuilder.newJob(QuartzJob.class)
                .usingJobData("message","QQQuartz")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printJobDetail())
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
