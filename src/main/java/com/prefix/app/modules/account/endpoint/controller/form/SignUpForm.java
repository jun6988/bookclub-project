package com.prefix.app.modules.account.endpoint.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignUpForm {
    @NotBlank
    //@NotNull
    @Length(min = 3, max = 20)
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$")
    private String nickname;

    @Email
    @NotNull
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 50)
    private String password;
}
