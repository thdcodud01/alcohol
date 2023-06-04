package com.ll.spirits.product.productEntity.product_cask;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.cask.Cask;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductCask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cask_id")
    private Cask cask;
}
