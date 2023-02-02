package com.example.demo.data.dao.cmm;

import java.util.List;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderDAO {
    List<CommonCodeHeaderResponseDto> findBySearchCondition(String commonCode, String commonCodeName, String systemCode);
    CommonCodeHeader insertCommonCodeHeader(CommonCodeHeader cch);
    CommonCodeHeader updateCommonCodeHeader(CommonCodeHeader cch) throws Exception;
    void deleteCommonCodeHeader(String commonCode) throws Exception;
}
