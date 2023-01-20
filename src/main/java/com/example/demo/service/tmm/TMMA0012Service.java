package com.example.demo.service.tmm;

import java.util.List;

import com.example.demo.model.tmm.TmCodexd;
import com.example.demo.model.tmm.TmCodexh;

public interface TMMA0012Service {
    public List<TmCodexh> getTmCodexh(String COMM_CDNM, String SYST_CODE);
    public List<TmCodexd> getTmCodexd(String COMM_CODE);
}
