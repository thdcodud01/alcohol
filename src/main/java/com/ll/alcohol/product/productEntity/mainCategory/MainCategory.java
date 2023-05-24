package com.ll.alcohol.product.productEntity.mainCategory;
import jakarta.persistence.*;

@Entity
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String mainCategory;
}
