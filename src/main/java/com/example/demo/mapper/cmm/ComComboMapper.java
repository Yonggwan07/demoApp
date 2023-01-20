package com.example.demo.mapper.cmm;

import java.util.List;
import java.util.Map;

import com.example.demo.model.cmm.ComCombo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComComboMapper {
    public List<ComCombo> getCombo(Map<String, String> params);
}
