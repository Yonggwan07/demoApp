package com.example.demo.mapper.tmm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.tmm.TmMessxm;

@Mapper
public interface TMMA0020Mapper {
    public List<TmMessxm> getTmMessxm(String MSGE_CNTT);
}
