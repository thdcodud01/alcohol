package com.ll.alcohol.product;

import com.ll.alcohol.abvRange.ABVrange;
import com.ll.alcohol.cask.Cask;
import com.ll.alcohol.costRange.CostRange;
import com.ll.alcohol.nation.Nation;
import com.ll.alcohol.netWeight.NetWeight;
import com.ll.alcohol.pairing.Pairing;
import com.ll.alcohol.type.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Type type; // (술 종류) 여러 술에 적용될 수 있지만 제품 당 술 종류는 무조건 한 개임 => ManyToOne

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
    private Pairing pairing; // (페어링 안주) 안주는 '여러 술'에 '여러 안주'가 적용될 수 있기 때문에 ManyToMany로 적용됨

    @ManyToMany
    private Cask cask; //(캐스크 - 오크통) 오크통은 한 개의 '제품 당 여러 개'가 사용될 수 있고 그 '제품 또한 여러 개'일 수 있기 때문에 ManyToMany로 적용됨

    @ManyToOne
    private Nation nation; // (생산국가) 생산국가는 여러 술이 있을 수 있지만 국가는 무조건 한 개임 => ManyToOne

    @Column(columnDefinition = "TEXT")
    private String info; // (제품상세정보) 제품상세정보는 직접 작성할 것이기 때문에 String 타입으로 지정
}
