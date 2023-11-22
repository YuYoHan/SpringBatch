package com.example.batch_sty;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 스프링 배치가 작동하기 위해 선언해야 하는 어노테이션
@EnableBatchProcessing
public class BatchStyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchStyApplication.class, args);
    }

}