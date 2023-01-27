package com.example.demo.data.repository.cmm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderRepository extends JpaRepository<CommonCodeHeader, String> {
    
}
