package com.ll.alcohol.product.productEntity.cask;
import jakarta.persistence.*;

@Entity
public class Cask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String cask;
}
