package com.ll.spirits.product.productEntity.pairing;
import com.ll.spirits.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String pairing;

    @ManyToOne // 이 테이블 기준에서는 ManyToOne입장이라 이렇게 어노테이션 달아줌.
    private Product product; // Product 테이블의 FK값
}
