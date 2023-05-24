package com.ll.spirits.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String type;

    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String abv; // 도수

    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String aroma; // 향

    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String flavor; // 맛

    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String cost;

    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String pairing; // 안주

    @NotEmpty(message = "필수 입력항목입니다.")
    @Size(max = 300)
    private String storage; // 보관방법

}
