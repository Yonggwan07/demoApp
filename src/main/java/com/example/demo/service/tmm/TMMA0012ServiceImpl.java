package com.example.demo.service.tmm;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.CommonCodeDetailDAO;
import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeDetail;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class TMMA0012ServiceImpl implements TMMA0012Service {

    private final CommonCodeHeaderDAO headerDao;
    private final CommonCodeDetailDAO detailDao;

    @Override
    public List<CommonCodeHeaderResponseDto> getHeader(String commonCodeName, String systemCode) {
        return headerDao.findBySearchCondition(commonCodeName, commonCodeName, systemCode);
    }

    @Override
    public List<CommonCodeDetail> getDetail(String COMM_CODE) {
        return detailDao.findByCommonCodeOrderBySortOrder(COMM_CODE);
    }
}
