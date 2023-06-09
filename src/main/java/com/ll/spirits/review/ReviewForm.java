package com.ll.spirits.review;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewForm {
    @NotEmpty(message = "내용 입력은 필수항목입니다.")
    private String content;
}
