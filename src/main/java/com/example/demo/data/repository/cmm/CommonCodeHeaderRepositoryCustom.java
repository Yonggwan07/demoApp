package com.example.demo.data.repository.cmm;

import java.util.List;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;

public interface CommonCodeHeaderRepositoryCustom {
    List<CommonCodeHeaderResponseDto> findBySearchCondition(String commonCode, String commonCodeName, String systemCode);
}
