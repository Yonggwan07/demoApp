package com.example.demo.service;

import java.util.List;

import javax.naming.AuthenticationException;

import com.example.demo.lib.SecureUtil;
import com.example.demo.mapper.ComAuthMapper;
import com.example.demo.model.MenuList;
import com.example.demo.model.SigninInfo;
import com.example.demo.model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComAuthServiceImpl implements ComAuthService {

    @Autowired
    private ComAuthMapper comAuthMapper;
    
    @Override
    public UserInfo signin(SigninInfo signinInfo) throws AuthenticationException {

        UserInfo userInfo = comAuthMapper.getUserInfo(signinInfo);

        if ((userInfo != null) && !userInfo.getUserIdxx().equals("")) {

            int lginTcnt = Integer.parseInt(String.valueOf(userInfo.getLginTcnt()));
            
            // 5회 이상 로그인에 실패할 경우 로그인 불가능
            if (lginTcnt >= 5) {
                throw new AuthenticationException("로그인 5회 실패하여 접속할 수 없습니다. 관리자에게 문의바랍니다.");
            }
            
            if (SecureUtil.encryptOnly(signinInfo.getPw()).equals(userInfo.getScrtNumb())) {
                // 로그인 성공
                return userInfo;
            } else {
                throw new AuthenticationException("INVALID_PASSWORD");
            }
        } else {
            throw new AuthenticationException("INVALID_CREDENTIALS");
        }
    }

    @Override
    public List<MenuList> getMenuList() {
        return comAuthMapper.getMenuList();
    }
}
