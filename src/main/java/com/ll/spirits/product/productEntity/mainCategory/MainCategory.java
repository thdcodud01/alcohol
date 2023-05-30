package com.ll.spirits.product.productEntity.mainCategory;
import com.ll.spirits.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String mainCategory;

//    @ManyToOne // 이 테이블 기준에서는 ManyToOne입장이라 이렇게 어노테이션 달아줌.
//    private Product products; // Product 테이블의 FK값

    @OneToMany(mappedBy = "mainCategory")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
