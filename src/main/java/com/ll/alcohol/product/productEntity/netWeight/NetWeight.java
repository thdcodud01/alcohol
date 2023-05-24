package com.ll.alcohol.product.productEntity.netWeight;
import jakarta.persistence.*;

@Entity
public class NetWeight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String netWeight; // ml단위 지켜서
}
