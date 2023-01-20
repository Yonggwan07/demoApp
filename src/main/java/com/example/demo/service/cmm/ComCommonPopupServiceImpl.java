package com.example.demo.service.cmm;

import java.util.List;
import java.util.Map;

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
    public ComCommonPopupInfo getCommonPopupInfo(Map<String, String> params) {
        return comCommonPopupMapper.getCommonPopupInfo(params);
    }

    @Override
    public List<JSONObject> getCommonPopupData(Map<String, String> params) {
       return sqlSession.selectList(params.get("POPP_XDAX"), params);
    }
}
