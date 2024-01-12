package com.example.batch1.batch.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "product")
@NoArgsConstructor
@Getter
public class ProductEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private int price;
    private String type;

    @Builder
    public ProductEntity(Long id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
