package com.ll.spirits.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {

    @NotEmpty(message = "제품이름은 필수 입력항목입니다.")
    @Size(max = 300)
    private String productName; // 제품이름

    @NotEmpty(message = "도수는 필수 입력항목입니다.")
    @Size(max = 300)
    private Double abv; // 도수

    @NotEmpty(message = "향은 필수 입력항목입니다.")
    @Size(max = 300)
    private String aroma; // 향

    @NotEmpty(message = "맛은 필수 입력항목입니다.")
    @Size(max = 300)
    private String flavor; // 맛

    @NotEmpty(message = "가격은 필수 입력항목입니다.")
    @Size(max = 300)
    private Integer cost; // 가격

    @NotEmpty(message = "제품정보는 필수 입력항목입니다.")
    @Size(max = 300)
    private String info; // 제품정보

}
