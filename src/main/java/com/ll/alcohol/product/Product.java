package com.ll.alcohol.product;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String type;

    @Column(length = 200)
    private String abv;

    @Column(columnDefinition = "TEXT")
    private String aroma;

    @Column(columnDefinition = "TEXT")
    private String flavor;

    @Column(length = 200)
    private String cost;

    @Column(columnDefinition = "TEXT")
    private String pairing;

    @Column(columnDefinition = "TEXT")
    private String storage;
}
