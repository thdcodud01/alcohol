package com.ll.alcohol.product.productEntity.costRange;
import jakarta.persistence.*;

@Entity
public class CostRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String costRange;
}
