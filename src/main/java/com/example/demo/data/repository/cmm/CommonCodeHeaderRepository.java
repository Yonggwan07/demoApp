package com.example.demo.data.repository.cmm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderRepository
        extends JpaRepository<CommonCodeHeader, String>, CommonCodeHeaderRepositoryCustom {
    List<CommonCodeHeader> findAllByCommonCodeContainingOrCommonCodeNameContainingAndSystemCode(String commonCode,
            String commonCodeName, String systemCode);
}
