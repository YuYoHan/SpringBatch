//package com.example.batch1.batch.job.file;
//
//import com.example.batch1.batch.chunk.processor.FileItemProcessor;
//import com.example.batch1.batch.domain.ProductDTO;
//import com.example.batch1.batch.entity.ProductEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.persistence.EntityManagerFactory;
//
//@Configuration
//@RequiredArgsConstructor
//public class FileJobConfiguration {
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final EntityManagerFactory entityManagerFactory;
//
//    @Bean
//    public Job fileJob() {
//        return jobBuilderFactory.get("fileJob")
//                .start(fileStep())
//                .build();
//    }
//
//    @Qualifier("fileStep")
//    @Bean
//    public Step fileStep() {
//        return stepBuilderFactory.get("fileStep")
//        .<ProductDTO, ProductEntity>chunk(10)
//                .reader(fileItemReader(null))
//                .processor(fileItemProcessor())
//                .writer(fileItemWriter())
//                .build();
//    }
//
//    @Bean
//    public FlatFileItemReader<ProductDTO> fileItemReader(@Value("#{jobParameters['requestDate']}") String requestDate) {
//        return new FlatFileItemReaderBuilder<ProductDTO>()
//                .name("flatFile")
//                .resource(new ClassPathResource("product_" + requestDate + ".csv"))
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<>())
//                .targetType(ProductDTO.class)
//                .linesToSkip(1)
//                .delimited().delimiter(",")
//                .names("id", "name", "price", "type")
//                .build();
//    }
//
//    @Bean
//    public ItemProcessor<ProductDTO, ProductEntity> fileItemProcessor() {
//        return new FileItemProcessor();
//    }
//
//    @Bean
//    public ItemWriter<ProductEntity> fileItemWriter() {
//        return new JpaItemWriterBuilder<ProductEntity>()
//                .entityManagerFactory(entityManagerFactory)
//                .usePersist(true)
//                .build();
//    }
//}
