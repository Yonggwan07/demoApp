package com.example.demo.data.dao.cmm;

import java.util.List;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;

public interface CommonCodeHeaderDAO {
    List<CommonCodeHeaderResponseDto> findBySearchCondition(String commonCode, String commonCodeName, String systemCode);
}
