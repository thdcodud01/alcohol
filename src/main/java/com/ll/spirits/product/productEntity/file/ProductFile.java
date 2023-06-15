package com.ll.spirits.product.productEntity.file;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String filename;

    @Column(columnDefinition = "TEXT")
    private String path;
}
