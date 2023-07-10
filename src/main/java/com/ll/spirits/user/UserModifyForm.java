package com.ll.spirits.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModifyForm {
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String PresentPW;

    @NotEmpty(message = "새 비밀번호를 입력해주세요.")
    private String newPW;

    @NotEmpty(message = "새 비밀번호를 다시 입력해주세요.")
    private String newPW2;
}
