package com.ll.alcohol.product.productEntity.pairing;
import jakarta.persistence.*;

@Entity
public class Pairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String pairing;
}
