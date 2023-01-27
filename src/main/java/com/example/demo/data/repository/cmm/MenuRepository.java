package com.example.demo.data.repository.cmm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.Menu;

public interface MenuRepository extends JpaRepository<Menu, String> {
    List<Menu> findAllByOrderBySortId();
}
