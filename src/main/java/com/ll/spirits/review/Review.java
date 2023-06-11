package com.ll.spirits.review;

import com.ll.spirits.product.Product;
import com.ll.spirits.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk속성 부여
    private Long id; // PK, Review 테이블의 id값

    @Column(columnDefinition = "TEXT") // TEXT 자료형으로 부여
    private String content; // Review 테이블의 내용 칼럼

    private LocalDateTime createDate; // Review 테이블의 작성일 칼럼
    private LocalDateTime modifyDate; // Review 테이블의 수정일 칼럼

    @ManyToOne // Review 기준에서는 ManyToOne입장이라 이렇게 어노테이션 달아줌.
    private Product product; // Product 테이블의 FK값
    // SHOW COLUMNS FROM review;
    @ManyToOne
    private SiteUser author; // 리뷰 작성자
    @ManyToMany
    Set<SiteUser> voter;
}
