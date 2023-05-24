package com.ll.alcohol.product.productEntity.abvRange;

import jakarta.persistence.*;

@Entity
public class ABVrange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String abvRange;
}
