package com.example.batch_sty.config;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 하나의 배치Job을 정의하고 빈 설정
@Configuration
@RequiredArgsConstructor
public class HelloJobConfig {
    // Job을 생성하는 빌더 팩토리
    private final JobBuilderFactory jobBuilderFactory;
    // Step을 생성하는 빌더 팩토리
    private final StepBuilderFactory stepBuilderFactory;

    // helloJob 이름으로 Job 생성
    @Bean
    public Job helloJob() {
        return jobBuilderFactory.get("helloJob")
                .start(helloStep())
                .build();
    }

    // helloJob 이름으로 Step 생성
    @Bean
    public Step helloStep() {
        return stepBuilderFactory.get("hellostep")
                // Step 안에서 단일 태스크로 수행되는 로직 구현
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("hello spring batch");
                    return RepeatStatus.FINISHED;
                })).build();
    }
}
