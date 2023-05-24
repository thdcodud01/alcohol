package com.ll.spirits.product.productEntity.costRange;
import com.ll.spirits.product.Product;
import jakarta.persistence.*;

@Entity
public class CostRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String costRange;

    @ManyToOne // 이 테이블 기준에서는 ManyToOne입장이라 이렇게 어노테이션 달아줌.
    private Product product; // Product 테이블의 FK값
}
