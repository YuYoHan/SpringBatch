//package com.example.batch1.batch.classifier;
//
//import com.example.batch1.batch.domain.ApiRequestDTO;
//import com.example.batch1.batch.domain.ProductDTO;
//import lombok.Setter;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.classify.Classifier;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Setter
//public class ProcessorClassifier<C, T> implements Classifier<C,T> {
//
//    private Map<String, ItemProcessor<ProductDTO, ApiRequestDTO>> processorMap = new HashMap<>();
//
//    @Override
//    // 여기에 ProductDTO 객체가 들어온다.
//    public T classify(C classifiable) {
//        return (T)processorMap.get(((ProductDTO)classifiable).getType());
//    }
//}
