package com.example.demo.service.cmm;

import java.util.List;

import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;

public interface ComUserService {
    UserResponseDto getUserInfo(String userId);

    public List<Menu> getMenuList();
}
