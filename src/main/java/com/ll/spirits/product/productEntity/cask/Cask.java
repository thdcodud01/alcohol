package com.ll.spirits.product.productEntity.cask;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.product_cask.ProductCask;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Cask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String cask;

    @OneToMany(mappedBy = "cask", cascade = CascadeType.ALL)
    private List<ProductCask> productCasks;
}
