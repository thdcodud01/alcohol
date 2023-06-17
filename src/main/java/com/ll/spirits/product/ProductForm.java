package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Component
@ToString
public class ProductForm {

    @NotEmpty(message = "제품이름은 필수 입력항목입니다.")
    @Size(max = 300)
    private String name; // 제품이름

    @NotNull(message = "도수는 필수 입력항목입니다.")
    private Double abv; // 도수

    @NotEmpty(message = "향은 필수 입력항목입니다.")
    @Size(max = 300)
    private String aroma; // 향

    @NotEmpty(message = "맛은 필수 입력항목입니다.")
    @Size(max = 300)
    private String flavor; // 맛

    @NotNull(message = "가격은 필수 입력항목입니다.")
    private Integer cost; // 가격

    @NotEmpty(message = "제품정보는 필수 입력항목입니다.")
    @Size(max = 5000, message = "제품정보는 최대 5000자까지 입력 가능합니다.")
    private String info; // 제품정보

    @NotNull(message = "대분류는 필수 입력항목입니다.")
    private Integer mainCategoryId; // 대분류 ID

    @NotNull(message = "중분류는 필수 입력항목입니다.")
    private Integer subCategoryId; // 중분류 ID
    @NotNull(message = "가격 범위는 필수 입력항목입니다.")
    private Integer costRangeId; // 가격 범위 ID
    @NotNull(message = "도수 범위는 필수 입력항목입니다.")
    private Integer abvRangeId; // 도수 범위 ID
    @NotNull(message = "중량은 필수 입력항목입니다.")
    private Integer netWeightId; // 중량 ID
    @NotNull(message = "어울리는 안주는 필수 입력항목입니다.")
    private List<Integer> pairings = new ArrayList<>(); // 페어링 엔티티 리스트
    @NotNull(message = "생산국가는 필수 입력항목입니다.")
    private Integer nationId; // 생산국가 ID

    private List<Integer> casks = new ArrayList<>(); // 캐스크 엔티티 리스트
}
