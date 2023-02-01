package com.example.demo.data.dto.cmm;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SignInResultDto extends SignUpResultDto {
    private String token;

    @Builder
    public SignInResultDto(boolean success, int code, String message, String token) {
        super(success, code, message);
        this.token = token;
    }
}
