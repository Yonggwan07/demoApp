package com.example.demo.data.dao.cmm.impl;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.CommonCodeDetailDAO;
import com.example.demo.data.repository.cmm.CommonCodeDetailRepository;

@Component
public class CommonCodeDetailDAOImpl implements CommonCodeDetailDAO {
    private final CommonCodeDetailRepository commonCodeDetailRepository;

    public CommonCodeDetailDAOImpl(CommonCodeDetailRepository commonCodeDetailRepository) {
        this.commonCodeDetailRepository = commonCodeDetailRepository;
    }
}
