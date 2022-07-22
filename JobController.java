package com.gimmenow.deliverynowrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.cron.Cron;

@RestController
public class JobController {

    @GetMapping("/run-one-time-job")
    public String runOneTimeJob() {
        BackgroundJob.enqueue(() -> System.out.println("This is Simple Job !"));
        return "Job is Executed";
    }

    @GetMapping("/run-delayed-job")
    public String runDelayedJob() {
        BackgroundJob.schedule(LocalDateTime.now().plusSeconds(5), () -> System.out.println("This is Delayed Job !"));
        return "Delayed Job Executed !";
    }

    @GetMapping("/run-recurrently-job")
    public String runRecurrentlyJob() {
        BackgroundJob.scheduleRecurrently(Cron.minutely(), () -> System.out.println("This is Recurrently Job"));
        return "Recurrently Job Executed !";
    }

}
