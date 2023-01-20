package com.example.demo.mapper;

import com.example.demo.model.MenuList;
import com.example.demo.model.SigninInfo;
import com.example.demo.model.UserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComAuthMapper {
    public UserInfo getUserInfo(SigninInfo signinInfo);
    public List<MenuList> getMenuList();
}
