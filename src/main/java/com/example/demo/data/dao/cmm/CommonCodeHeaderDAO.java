package com.example.demo.data.dao.cmm;

import java.util.Optional;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface CommonCodeHeaderDAO {
    Optional<CommonCodeHeader> selectCommonCode(String commonCode);
}
