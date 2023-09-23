package com.fxwebapp.fxrates.configuration;

import com.fxwebapp.fxrates.jobs.UpdateRateHistoryJob;
import com.fxwebapp.fxrates.jobs.UpdateRatesJob;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzJobs {
    private static final String CRON_EVERY_DAY_6AM = "0 0 6 * * ?";
    private static final String CRON_EVERY_DAY_6_10AM = "0 10 6 * * ?";

    @Bean(name = "updateRates")
    public JobDetailFactoryBean jobUpdateRates() {
        return QuartzConfiguration.createJobDetail(UpdateRatesJob.class, "updateRatesJob");
    }

    @Bean(name = "updateRateHistory")
    public JobDetailFactoryBean jobUpdateRateHistory() {
        return QuartzConfiguration.createJobDetail(UpdateRateHistoryJob.class, "updateRateHistoryJob");
    }

    @Bean(name = "updateRatesTrigger")
    public CronTriggerFactoryBean triggerUpdateRates(@Qualifier("updateRates") JobDetail jobDetail) {
        return QuartzConfiguration.createCronTrigger(jobDetail, CRON_EVERY_DAY_6AM, "updateRatesTrigger");
    }

    @Bean(name = "updateRateHistoryTrigger")
    public CronTriggerFactoryBean triggerUpdateRateHistory(@Qualifier("updateRateHistory") JobDetail jobDetail) {
        return QuartzConfiguration.createCronTrigger(jobDetail, CRON_EVERY_DAY_6_10AM, "updateRateHistoryTrigger");
    }
}
