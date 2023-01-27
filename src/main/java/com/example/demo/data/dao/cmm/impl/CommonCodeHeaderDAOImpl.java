package com.example.demo.data.dao.cmm.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.example.demo.data.repository.cmm.CommonCodeHeaderRepository;

@Component
public class CommonCodeHeaderDAOImpl implements CommonCodeHeaderDAO {
    private final CommonCodeHeaderRepository commonCodeHeaderRepository;

    public CommonCodeHeaderDAOImpl(CommonCodeHeaderRepository commonCodeHeaderRepository) {
        this.commonCodeHeaderRepository = commonCodeHeaderRepository;
    }

    @Override
    public Optional<CommonCodeHeader> selectCommonCode(String commonCode) {
        return commonCodeHeaderRepository.findById(commonCode);
    }

    @Override
    public List<CommonCodeHeader> findByCommonCodeContainingOrCommonCodeNameContainingAndSystemCode(String commonCodeName, String systemCode) {
        return commonCodeHeaderRepository.findAllByCommonCodeContainingOrCommonCodeNameContainingAndSystemCode(commonCodeName,
                commonCodeName, systemCode);
    }

    @Override
    public List<CommonCodeHeader> findBySearchCondition(String commonCode, String commonCodeName, String systemCode) {
        return commonCodeHeaderRepository.findBySearchCondition(commonCode, commonCodeName, systemCode);
    }
}
