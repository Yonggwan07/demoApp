package com.example.demo.service;

import java.util.List;

import javax.naming.AuthenticationException;

import com.example.demo.model.MenuList;
import com.example.demo.model.SigninInfo;
import com.example.demo.model.UserInfo;

public interface ComAuthService {
    public UserInfo signin(SigninInfo signinInfo) throws AuthenticationException;
    public List<MenuList> getMenuList();
}
