package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private MainCategory mainCategory; // (술 종류) 여러 술에 적용될 수 있지만 제품 당 술 종류는 무조건 한 개임 => ManyToOne

    @ManyToOne
    private SubCategory subCategory; // (술 종류) 여러 술에 적용될 수 있지만 제품 당 술 종류는 무조건 한 개임 => ManyToOne

    @Column(length = 200)
    private String name; // (이름)술 이름은 직접 작성할 것이기 때문에 String 타입으로 지정

    @ManyToOne
    private CostRange costRange; // (가격 범위)여러 술에 적용될 수 있지만 제품 당 가격 범위는 무조건 한 개임 => ManyToOne

    @Column(length = 200)
    private Integer cost; // (가격)술 가격은 직접 작성할 것이기 때문에 Integer 타입으로 지정

    @ManyToOne
    private ABVrange abvRange; // (도수 범위)여러 술에 적용될 수 있지만 제품 당 도수 범위는 무조건 한 개임 => ManyToOne

    @Column(length = 200)
    private Double abv; // (도수)술 도수는 직접 작성할 것이기 때문에 Double 타입으로 지정

    @ManyToOne
    private NetWeight netWeight; // (중량)여러 술에 적용될 수 있지만 제품 당 중량은 무조건 한 개임 => ManyToOne

    @Column(columnDefinition = "TEXT")
    private String flavor; // (맛)맛은 직접 작성할 것이기 때문에 String 타입으로 지정

    @Column(columnDefinition = "TEXT")
    private String aroma; // (향)향은 직접 작성할 것이기 때문에 String 타입으로 지정

    @ManyToMany
    @JoinTable(
            name = "product_pairings",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "pairing_id")
    )
    private List<Pairing> pairings;

    @ManyToMany
    @JoinTable(
            name = "product_casks",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cask_id")
    )
    private List<Cask> casks;

    // product_pairing 테이블과 product_cask 테이블을 생성하여
    // Product 엔티티와 Pairing 엔티티, 그리고 Product 엔티티와 Cask 엔티티 간의 다대다 관계를 매핑
    // Product 엔티티는 pairings 필드와 casks 필드를 통해 해당 제품과 연관된 페어링과 캐스크 목록을 가져올 수 있게 됨

    @ManyToOne
    private Nation nation; // (생산국가) 생산국가는 여러 술이 있을 수 있지만 국가는 무조건 한 개임 => ManyToOne

    @Column(columnDefinition = "TEXT")
    private String info; // (제품상세정보) 제품상세정보는 직접 작성할 것이기 때문에 String 타입으로 지정

    @ManyToOne
    private SiteUser author; // 여러 제품에 적용될 수 있지만 제품 당 작성자는 무조건 하나임 => ManyToOne

    @ManyToMany
    Set<SiteUser> voter;

    @ManyToMany
    Set<SiteUser> wish;
}
