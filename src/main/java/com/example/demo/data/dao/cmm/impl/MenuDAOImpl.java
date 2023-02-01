package com.example.demo.data.dao.cmm.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.MenuDAO;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.data.repository.cmm.MenuRepository;

@Component
public class MenuDAOImpl implements MenuDAO {
    private final MenuRepository menuRepository;

    public MenuDAOImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> findMenus() {
        return menuRepository.findAllByOrderBySortId();
    }
}
