package com.example.demo.service.tmm;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeHeader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TMMA0011ServiceImpl implements TMMA0011Service {

    private final CommonCodeHeaderDAO dao;

    @Override
    public List<CommonCodeHeaderResponseDto> get(String commonCodeName, String systemCode) {
        return dao.findBySearchCondition(commonCodeName, commonCodeName, systemCode);
    }

    @Override
    public CommonCodeHeader save(CommonCodeHeader cch) {
        return dao.insertCommonCodeHeader(cch);
    }

    @Override
    public CommonCodeHeader update(CommonCodeHeader cch) throws Exception {
        return dao.updateCommonCodeHeader(cch);
    }

    @Override
    public void delete(String commonCode) throws Exception {
        dao.deleteCommonCodeHeader(commonCode);
    }
}
