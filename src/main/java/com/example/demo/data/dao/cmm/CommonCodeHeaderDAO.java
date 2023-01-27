package com.example.demo.data.dao.cmm;

import java.util.List;
import java.util.Optional;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderDAO {
    Optional<CommonCodeHeader> selectCommonCode(String commonCode);

    List<CommonCodeHeader> findByCommonCodeContainingOrCommonCodeNameContainingAndSystemCode(String commonCodeName, String systemCode);
    List<CommonCodeHeader> findBySearchCondition(String commonCode, String commonCodeName, String systemCode);
}
