package com.example.demo.service.tmm;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.tmm.TMMA0011Mapper;
import com.example.demo.model.tmm.TmCodexh;

@Service
public class TMMA0011ServiceImpl implements TMMA0011Service {

    private final TMMA0011Mapper tmma0011Mapper;

    public TMMA0011ServiceImpl(TMMA0011Mapper tmma0011Mapper) {
        this.tmma0011Mapper = tmma0011Mapper;
    }

    @Override
    public List<TmCodexh> getTmCodexh(String COMM_CDNM, String SYST_CODE) {
        return tmma0011Mapper.getTmCodexh(COMM_CDNM, SYST_CODE);
    }
    
    @Override
    public int save00(List<Map<String, String>> data) {

        int iToCnt = 0;

        for (Map<String, String> row : data) {

            String rowStatus = row.get("state");

            if (rowStatus == null) {
                row.put("UPDT_USID", "demoTester");
                tmma0011Mapper.update00(row);
                iToCnt++;
            } else if (rowStatus.equals("i")) {
                row.put("UPDT_USID", "demoTester");
                tmma0011Mapper.insert00(row);
                iToCnt++;
            } else if (rowStatus.equals("d")) {
                tmma0011Mapper.delete00(row);
                iToCnt++;
            }
        }

        return iToCnt;
    }
}
