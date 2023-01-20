package com.example.demo.mapper.tmm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.tmm.TmCodexd;
import com.example.demo.model.tmm.TmCodexh;

@Mapper
public interface TMMA0012Mapper {
    public List<TmCodexh> getTmCodexh(String COMM_CDNM, String SYST_CODE);
    public List<TmCodexd> getTmCodexd(String COMM_CODE);
}
