package com.example.demo.service.cmm;

import org.springframework.security.core.AuthenticationException;

import com.example.demo.data.dto.cmm.SignInResultDto;
import com.example.demo.data.dto.cmm.SignUpResultDto;

public interface ComAuthService {
    SignUpResultDto signUp(String userId, String password, String username, String role);

    SignInResultDto signIn(String userId, String password) throws AuthenticationException;
}
