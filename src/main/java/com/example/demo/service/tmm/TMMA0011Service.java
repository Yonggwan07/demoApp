package com.example.demo.service.tmm;

import java.util.List;
import java.util.Map;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;

public interface TMMA0011Service {
    public List<CommonCodeHeaderResponseDto> getCommonCodeHeaders(String commonCodeName, String systemCode);

    public int save00(List<Map<String, String>> params);
}
