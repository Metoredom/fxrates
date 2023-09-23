package com.fxwebapp.fxrates.jobs;

import com.fxwebapp.fxrates.services.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@DisallowConcurrentExecution
public class UpdateRateHistoryJob implements Job {

    @Autowired
    private SyncService syncService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            System.out.println("Sync rates history started");
            syncService.syncHistory();
            System.out.println("Sync rates history done");
        } catch (Exception e) {
            System.err.println("Error by updating rates!");
            throw new RuntimeException(e);
        }
        System.out.println("Data successfully updated!");
    }


}
