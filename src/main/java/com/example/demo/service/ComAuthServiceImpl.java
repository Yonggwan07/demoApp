package com.example.demo.service;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.UserDAO;
import com.example.demo.data.dto.cmm.UserDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.User;
import com.example.demo.lib.SecureUtil;
import com.example.demo.mapper.ComAuthMapper;
import com.example.demo.model.MenuList;
import com.example.demo.model.SigninInfo;
import com.example.demo.model.UserInfo;

@Service
public class ComAuthServiceImpl implements ComAuthService {

    private final UserDAO userDAO;

    public ComAuthServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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
    public UserResponseDto signin(UserDto user) throws AuthenticationException {
        User selected = userDAO.selectUser(user.getUserId());

        if (selected != null) {
            if (user.getPassword().equals(selected.getPassword())) {
                UserResponseDto userResponseDto = new UserResponseDto();
                userResponseDto.setUserId(selected.getUserId());
                userResponseDto.setUserNumber(selected.getUserNumber());
                userResponseDto.setUserName(selected.getUserName());
                return userResponseDto;
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
