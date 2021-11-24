package com.spring.hanghaeblog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter

public class SignupRequestDto {
    private Long id;
//    private String username;
//    private String password;

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9a-zA-Z])(?=\\S+$).{3,12}",
            message = "아이디는 영문 대,소문자와 숫자를 이용해 3자 ~ 12자를 입력해주세요.")
    @Size(min = 3, max = 12, message = "아이디는 영문 대,소문자와 숫자를 이용해 3자 ~ 12자를 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9a-zA-Z])(?=\\S+$).{4,12}",
            message = "비밀번호는 영문 대,소문자와 숫자를 이용해 4자 ~ 12자를 입력해주세요.")
    @Size(min = 3, max = 12, message = "아이디는 영문 대,소문자와 숫자를 이용해 3자 ~ 12자를 입력해주세요.")
    private String password;


    @Builder
    public SignupRequestDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}

