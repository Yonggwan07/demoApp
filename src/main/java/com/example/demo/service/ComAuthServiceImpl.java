package com.example.demo.service;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.MenuDAO;
import com.example.demo.data.dao.cmm.UserDAO;
import com.example.demo.data.dto.cmm.UserDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.data.entity.cmm.User;

@Service
public class ComAuthServiceImpl implements ComAuthService {

    private final UserDAO userDAO;
    private final MenuDAO menuDAO;

    public ComAuthServiceImpl(UserDAO userDAO, MenuDAO menuDAO) {
        this.userDAO = userDAO;
        this.menuDAO = menuDAO;
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

    // @Override
    // public List<MenuList> getMenuList() {
    //     return comAuthMapper.getMenuList();
    // }

    @Override
    public List<Menu> getMenuList() {
        return menuDAO.selectMenuList();
    }
}
