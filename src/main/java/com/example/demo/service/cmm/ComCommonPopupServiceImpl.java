package com.example.demo.service.cmm;

import java.util.List;

import org.json.simple.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.cmm.ComCommonPopupMapper;
import com.example.demo.model.cmm.ComCommonPopupInfo;

@Service
public class ComCommonPopupServiceImpl implements ComCommonPopupService {

    @Autowired
    private ComCommonPopupMapper comCommonPopupMapper;
    
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public ComCommonPopupInfo getCommonPopupInfo(String popupId) {
        return comCommonPopupMapper.getCommonPopupInfo(popupId);
    }

    @Override
    public List<JSONObject> getCommonPopupData(String POPP_XDAX, String COMM_CDNM) {
       return sqlSession.selectList(POPP_XDAX, COMM_CDNM);
    }
}
