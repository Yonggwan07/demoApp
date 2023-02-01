package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.AuthenticationException;

import com.example.demo.data.dto.cmm.SignInResultDto;
import com.example.demo.data.dto.cmm.SignUpResultDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;

public interface ComAuthService {
    SignUpResultDto signUp(String userId, String password, String username, String role);

    SignInResultDto signIn(String userId, String password) throws AuthenticationException;

    UserResponseDto getUser(String userId);

    public List<Menu> getMenuList();
}
