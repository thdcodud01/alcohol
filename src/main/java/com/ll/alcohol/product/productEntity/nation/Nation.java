package com.ll.alcohol.product.productEntity.nation;
import jakarta.persistence.*;

@Entity
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String nation;
}
