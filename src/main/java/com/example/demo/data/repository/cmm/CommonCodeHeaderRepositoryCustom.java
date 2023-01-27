package com.example.demo.data.repository.cmm;

import java.util.List;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderRepositoryCustom {
    List<CommonCodeHeader> findBySearchCondition(String commonCode, String commonCodeName, String systemCode);
}
