//package com.example.batch1.batch.chunk.processor;
//
//import com.example.batch1.batch.domain.ProductDTO;
//import com.example.batch1.batch.entity.ProductEntity;
//import org.modelmapper.ModelMapper;
//import org.springframework.batch.item.ItemProcessor;
//
//public class FileItemProcessor implements ItemProcessor<ProductDTO, ProductEntity> {
//    @Override
//    public ProductEntity process(ProductDTO item) throws Exception {
//        ModelMapper modelMapper = new ModelMapper();
//        ProductEntity product = modelMapper.map(item, ProductEntity.class);
//        return product;
//    }
//}
