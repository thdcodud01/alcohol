package com.ll.spirits.product.productEntity.pairing;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.product_cask.ProductCask;
import com.ll.spirits.product.productEntity.product_pairing.ProductPairing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Pairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String pairing;

    @OneToMany(mappedBy = "pairing", cascade = CascadeType.ALL)
    private List<ProductPairing> productPairings;
}
