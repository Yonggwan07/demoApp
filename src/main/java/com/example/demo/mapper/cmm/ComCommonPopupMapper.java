package com.example.demo.mapper.cmm;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.cmm.ComCommonPopupInfo;

@Mapper
public interface ComCommonPopupMapper {

    public ComCommonPopupInfo getCommonPopupInfo(String POPP_CODE);
}
