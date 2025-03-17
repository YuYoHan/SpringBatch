package com.example.batch_sty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final JobLauncher jobLauncher;
    private final JobRegistry jobRegistry;

    @GetMapping("/first")
    public String firstApi(@RequestParam("value") String value) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("data", value)
                .toJobParameters();
        jobLauncher.run(jobRegistry.getJob("firstJob"), jobParameters);
        return "ok";
    }
}
