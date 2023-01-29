package com.example.demo.service;

import java.util.List;

import javax.naming.AuthenticationException;

import com.example.demo.data.dto.cmm.UserDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;

public interface ComAuthService {
    public UserResponseDto signin(UserDto user) throws AuthenticationException;
    //public List<MenuList> getMenuList();
    public List<Menu> getMenuList();
}
