package com.fxwebapp.fxrates.configuration;

import com.fxwebapp.fxrates.jobs.UpdateRatesJob;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzJobs {
    private static final String CRON_EVERY_DAY = "0 0 6 * * ?";

    @Bean(name = "updateRates")
    public JobDetailFactoryBean jobMemberClassStats() {
        return QuartzConfiguration.createJobDetail(UpdateRatesJob.class, "updateRatesJob");
    }

    @Bean(name = "updateRatesTrigger")
    public CronTriggerFactoryBean triggerMemberClassStats(@Qualifier("updateRates") JobDetail jobDetail) {
        return QuartzConfiguration.createCronTrigger(jobDetail, CRON_EVERY_DAY, "updateRatesTrigger");
    }
}
