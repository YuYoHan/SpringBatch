package com.example.batch_sty.entity.mysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BeforeEntity {
    @Id @GeneratedValue
    private Long id;

    private String userName;
}
