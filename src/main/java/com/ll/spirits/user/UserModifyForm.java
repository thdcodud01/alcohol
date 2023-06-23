package com.ll.spirits.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class UserModifyForm {

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String presentPW;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String newPW;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String newPW2;
}
