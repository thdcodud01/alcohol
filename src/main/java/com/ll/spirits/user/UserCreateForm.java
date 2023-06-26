package com.ll.spirits.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Component
public class UserCreateForm {
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    @Email
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @Size(min = 3, max = 25)
    @NotEmpty(message = "닉네임은 필수항목입니다.")
    private String nickname;

    private LocalDate birthDate;

    private int mailKey;
}
/*
UserCreateForm(userId=XXZ@sad.com, password1=1234, password2=1234, email=XXZ@sad.com, nickname=213132)
Hibernate:
    insert
    into
        site_user
        (email, nickname, password, user_id)
    values
        (?, ?, ?, ?)
        
        칼럼순서 맞춰줄 것
*/