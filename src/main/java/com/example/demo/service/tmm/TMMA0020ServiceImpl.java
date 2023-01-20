package com.example.demo.service.tmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.tmm.TMMA0020Mapper;
import com.example.demo.model.tmm.TmMessxm;

@Service
public class TMMA0020ServiceImpl implements TMMA0020Service {

    @Autowired
    private TMMA0020Mapper tmma0020Mapper;

    @Override
    public List<TmMessxm> getTmMessxm(String MSGE_CNTT) {
        return tmma0020Mapper.getTmMessxm(MSGE_CNTT);
    }
}
