package com.example.demo.mapper.tmm;

import java.util.List;
import java.util.Map;

import com.example.demo.model.tmm.TmCodexh;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMMA0011Mapper {
    public List<TmCodexh> getTmCodexh(String COMM_CDNM, String SYST_CODE);

    public int insert00(Map<String, String> data);

    public int update00(Map<String, String> data);

    public int delete00(Map<String, String> data);
}
