//package com.example.batch1.batch.job.api;
//
//import com.example.batch1.batch.listener.JobListener;
//import com.example.batch1.batch.tasklet.ApiEndTasklet;
//import com.example.batch1.batch.tasklet.ApiStartTasklet;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@RequiredArgsConstructor
//public class ApiJobConfiguration {
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final ApiStartTasklet apiStartTasklet;
//    private final ApiEndTasklet apiEndTasklet;
//    private final Step jobStep;
//
//    @Bean
//    public Job apiJob() {
//        return jobBuilderFactory.get("apiJob")
//                // job이 최종적으로 실행 이후에 시작 시간부터 종료시간까지
//                // 소요된 시간을 측정하는 job리스너
//                .listener(new JobListener())
//                .start(apiStep1())
//                .next(jobStep)
//                .next(apiStep2())
//                .build();
//    }
//
//    @Bean
//    public Step apiStep1() {
//        return stepBuilderFactory.get("apiStep1")
//                .tasklet(apiStartTasklet)
//                .build();
//    }
//    @Bean
//    public Step apiStep2() {
//        return stepBuilderFactory.get("apiStep2")
//                .tasklet(apiStartTasklet)
//                .build();
//    }
//}
