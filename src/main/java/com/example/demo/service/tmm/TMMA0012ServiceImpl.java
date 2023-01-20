package com.example.demo.service.tmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.tmm.TMMA0012Mapper;
import com.example.demo.model.tmm.TmCodexd;
import com.example.demo.model.tmm.TmCodexh;

@Service
public class TMMA0012ServiceImpl implements TMMA0012Service {

    @Autowired
    private TMMA0012Mapper tmma0012Mapper;

    @Override
    public List<TmCodexh> getTmCodexh(String COMM_CDNM, String SYST_CODE) {
        return tmma0012Mapper.getTmCodexh(COMM_CDNM, SYST_CODE);
    }

    @Override
    public List<TmCodexd> getTmCodexd(String COMM_CODE) {
        return tmma0012Mapper.getTmCodexd(COMM_CODE);
    }
}
