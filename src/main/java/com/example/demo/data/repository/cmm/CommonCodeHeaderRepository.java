package com.example.demo.data.repository.cmm;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderRepository
        extends JpaRepository<CommonCodeHeader, Long>, CommonCodeHeaderRepositoryCustom {
    Optional<CommonCodeHeader> findByCommonCode(String commonCode);
}
