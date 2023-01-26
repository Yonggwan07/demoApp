package com.example.demo.service;

import java.util.List;

import javax.naming.AuthenticationException;

import com.example.demo.data.dto.cmm.UserDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.model.SigninInfo;
import com.example.demo.model.UserInfo;

public interface ComAuthService {
    public UserInfo signin(SigninInfo signinInfo) throws AuthenticationException;
    public UserResponseDto signin(UserDto user) throws AuthenticationException;
    //public List<MenuList> getMenuList();
    public List<Menu> getMenuList();
}
