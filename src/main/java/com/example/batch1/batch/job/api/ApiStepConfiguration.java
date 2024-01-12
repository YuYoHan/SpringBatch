//package com.example.batch1.batch.job.api;
//
//import com.example.batch1.batch.classifier.ProcessorClassifier;
//import com.example.batch1.batch.domain.ApiRequestDTO;
//import com.example.batch1.batch.domain.ProductDTO;
//import com.example.batch1.batch.partition.ProductPartitioner;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
//import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@RequiredArgsConstructor
//public class ApiStepConfiguration {
//    private final StepBuilderFactory stepBuilderFactory;
//    private final DataSource dataSource;
//
//    private int chunkSize = 10;
//
//    @Bean
//    public Step apiMasterStep() throws Exception {
//        return stepBuilderFactory.get("apiMasterStep")
//                .partitioner(apiSlaveStep().getName(), partitioner())
//                .step(apiSlaveStep())
//                .gridSize(3)
//                .taskExecutor(taskExecuter())
//                .build();
//    }
//
//    @Bean
//    public TaskExecutor taskExecuter() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setCorePoolSize(3);
//        taskExecutor.setMaxPoolSize(6);
//        taskExecutor.setThreadNamePrefix("api-thread-");
//        return null;
//    }
//
//    @Bean
//    public Step apiSlaveStep() throws Exception {
//        return stepBuilderFactory.get("apiSlaveStep")
//                .<ProductDTO, ProductDTO>chunk(chunkSize)
//                .reader(itemReader(null))
//                .processor(itemProcessor())
//                .writer(iitemWriter())
//                .build();
//    }
//
//    @Bean
//    public ProductPartitioner partitioner() {
//        ProductPartitioner partitioner = new ProductPartitioner();
//        partitioner.setDataSource(dataSource);
//        return partitioner;
//    }
//
//    @Bean
//    @StepScope
//    public ItemReader<ProductDTO> itemReader(@Value("#{stepExecutionContext['product']}") ProductDTO productDTO) throws  Exception{
//        JdbcPagingItemReader<ProductDTO> reader = new JdbcPagingItemReader<>();
//        reader.setDataSource(dataSource);
//        reader.setPageSize(chunkSize);
//        reader.setRowMapper(new BeanPropertyRowMapper(ProductDTO.class));
//
//        MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
//        queryProvider.setSelectClause("id, name, price, type");
//        queryProvider.setFromClause("from product");
//        queryProvider.setWhereClause("where type = :type");
//
//        Map<String, Order> sortKeys = new HashMap<>(1);
//        sortKeys.put("id", Order.DESCENDING);
//        queryProvider.setSortKeys(sortKeys);
//
//        reader.setParameterValues(QueryGenerator.getParameterForQuery("type", productDTO.getType()));
//        reader.setQueryProvider(queryProvider);
//        reader.afterPropertiesSet();
//        return reader;
//    }
//
//    @Bean
//    public ItemProcessor itemProcessor() {
//        ClassifierCompositeItemProcessor<ProductDTO, ApiRequestDTO> processor =
//                new ClassifierCompositeItemProcessor<ProductDTO, ApiRequestDTO>();
//
//        ProcessorClassifier<ProductDTO, ItemProcessor<?,? extends ApiRequestDTO>> classifier =
//                new ProcessorClassifier();
//
//        Map<String, ItemProcessor<ProductDTO, ApiRequestDTO>> processorMap = new HashMap<>();
//        processorMap.put("1", new ApiItemProcessor1());
//        processorMap.put("2", new ApiItemProcessor2());
//        processorMap.put("3", new ApiItemProcessor3());
//    }
//}
