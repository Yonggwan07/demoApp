package com.example.demo.data.dao.cmm.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.repository.cmm.CommonCodeHeaderRepository;

@Component
public class CommonCodeHeaderDAOImpl implements CommonCodeHeaderDAO {
    private final CommonCodeHeaderRepository commonCodeHeaderRepository;

    public CommonCodeHeaderDAOImpl(CommonCodeHeaderRepository commonCodeHeaderRepository) {
        this.commonCodeHeaderRepository = commonCodeHeaderRepository;
    }

    @Override
    public List<CommonCodeHeaderResponseDto> findBySearchCondition(String commonCode, String commonCodeName,
            String systemCode) {
        return commonCodeHeaderRepository.findBySearchCondition(commonCode, commonCodeName, systemCode);
    }
}
