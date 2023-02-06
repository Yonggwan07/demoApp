package com.example.demo.service.tmm;

import java.util.List;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeDetail;

public interface TMMA0012Service {
    public List<CommonCodeHeaderResponseDto> getHeader(String commonCodeName, String systemCode);
    public List<CommonCodeDetail> getDetail(String commonCode);
}
