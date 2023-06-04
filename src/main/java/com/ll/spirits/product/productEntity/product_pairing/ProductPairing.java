package com.ll.spirits.product.productEntity.product_pairing;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductPairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pairing_id")
    private Pairing pairing;
}
