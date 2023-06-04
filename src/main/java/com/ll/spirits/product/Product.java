package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.product_cask.ProductCask;
import com.ll.spirits.product.productEntity.product_pairing.ProductPairing;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
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

    @ManyToOne
    private Pairing pairing;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductPairing> productPairings;

    @ManyToOne
    private Cask cask;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCask> productCasks; //(캐스크 - 오크통) 오크통은 한 개의 '제품 당 여러 개'가 사용될 수 있고 그 '제품 또한 여러 개'일 수 있기 때문에 ManyToMany로 적용됨

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
