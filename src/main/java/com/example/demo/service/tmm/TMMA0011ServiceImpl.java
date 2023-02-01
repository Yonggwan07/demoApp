package com.example.demo.service.tmm;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TMMA0011ServiceImpl implements TMMA0011Service {

    private final CommonCodeHeaderDAO commonCodeHeaderDAO;

    @Override
    public List<CommonCodeHeaderResponseDto> getCommonCodeHeaders(String commonCodeName, String systemCode) {
        return commonCodeHeaderDAO.findBySearchCondition(commonCodeName, commonCodeName, systemCode);
    }

    @Override
    public int save00(List<Map<String, String>> data) {

        // int iToCnt = 0;

        // for (Map<String, String> row : data) {

        // String rowStatus = row.get("state");

        // if (rowStatus == null) {
        // row.put("UPDT_USID", "demoTester");
        // tmma0011Mapper.update00(row);
        // iToCnt++;
        // } else if (rowStatus.equals("i")) {
        // row.put("UPDT_USID", "demoTester");
        // tmma0011Mapper.insert00(row);
        // iToCnt++;
        // } else if (rowStatus.equals("d")) {
        // tmma0011Mapper.delete00(row);
        // iToCnt++;
        // }
        // }

        // return iToCnt;
        return -1;
    }
}
