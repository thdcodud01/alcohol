package com.ll.spirits.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductForm {

    @NotEmpty(message = "제품이름은 필수 입력항목입니다.")
    @Size(max = 300)
    private String name; // 제품이름

    @NotEmpty(message = "도수는 필수 입력항목입니다.")
    private Double abv; // 도수

    @NotEmpty(message = "향은 필수 입력항목입니다.")
    @Size(max = 300)
    private String aroma; // 향

    @NotEmpty(message = "맛은 필수 입력항목입니다.")
    @Size(max = 300)
    private String flavor; // 맛

    @NotEmpty(message = "가격은 필수 입력항목입니다.")
    private Integer cost; // 가격

    @NotEmpty(message = "제품정보는 필수 입력항목입니다.")
    @Size(max = 300)
    private String info; // 제품정보

    @NotEmpty(message = "대분류는 필수 입력항목입니다.")
    private Integer mainCategoryId; // 대분류 ID
    @NotEmpty(message = "Main Category is required.")
    private String mainCategory; // Main Category 정보를 담을 필드


    @NotEmpty(message = "중분류는 필수 입력항목입니다.")
    private Integer subCategoryId; // 중분류 ID
    @NotEmpty(message = "가격 범위는 필수 입력항목입니다.")
    private Integer costRangeId; // 가격 범위 ID
    @NotEmpty(message = "도수 범위는 필수 입력항목입니다.")
    private Integer abvRangeId; // 도수 범위 ID
    @NotEmpty(message = "중량은 필수 입력항목입니다.")
    private Integer netWeightId; // 중량 ID
    @NotEmpty(message = "어울리는 안주는 필수 입력항목입니다.")
    private List<Integer> pairingIds; // 페어링 ID 리스트
    @NotEmpty(message = "생산국가는 필수 입력항목입니다.")
    private Integer nationId; // 생산국가 ID

    private List<Integer> caskIds; // 캐스크 ID 리스트

}
