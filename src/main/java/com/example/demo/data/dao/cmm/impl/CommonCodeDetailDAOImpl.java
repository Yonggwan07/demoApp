package com.example.demo.data.dao.cmm.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.CommonCodeDetailDAO;
import com.example.demo.data.entity.cmm.CommonCodeDetail;
import com.example.demo.data.repository.cmm.CommonCodeDetailRepository;

@Component
public class CommonCodeDetailDAOImpl implements CommonCodeDetailDAO {
    private final CommonCodeDetailRepository commonCodeDetailRepository;

    public CommonCodeDetailDAOImpl(CommonCodeDetailRepository commonCodeDetailRepository) {
        this.commonCodeDetailRepository = commonCodeDetailRepository;
    }

    @Override
    public List<CommonCodeDetail> findByCommonCodeOrderBySortOrder(String commonCode) {
        return commonCodeDetailRepository.findByCommonCodeOrderBySortOrder(commonCode);
    }
}
