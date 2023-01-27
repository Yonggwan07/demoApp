package com.example.demo.service.tmm;

import java.util.List;
import java.util.Map;

import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.example.demo.model.tmm.TmCodexh;

public interface TMMA0011Service {
    public List<TmCodexh> getTmCodexh(String COMM_CDNM, String SYST_CODE);
    public List<CommonCodeHeader> getCommonCodeHeaders(String commonCodeName, String systemCode);

    public int save00(List<Map<String, String>> params);
}
