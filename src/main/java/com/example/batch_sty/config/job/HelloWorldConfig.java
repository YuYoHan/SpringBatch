package com.example.batch_sty.config.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldConfig {
    // Job을 생성하는 빌더 팩토리
    private final JobBuilderFactory jobBuilderFactory;
    // Step을 생성하는 빌더 팩토리
    private final StepBuilderFactory stepBuilderFactory;

    // helloJob 이름으로 Job 생성
    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloJob")
                .incrementer(new RunIdIncrementer())
                .start(helloWorldStep())
                .build();
    }

    // helloStep 이름으로 Step 생성
    @JobScope
    @Bean
    public Step helloWorldStep() {
        return stepBuilderFactory.get("helloStep")
                .tasklet(helloWroldTasklet())
                .build();
    }

    // Step 안에서 단일 태스크로 수행되는 로직 구현
    @StepScope
    @Bean
    public Tasklet helloWroldTasklet() {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution,
                                        ChunkContext chunkContext) throws Exception {
                System.out.println("Hello World Spring Batch");
                return RepeatStatus.FINISHED;
            }
        };
    }
}
