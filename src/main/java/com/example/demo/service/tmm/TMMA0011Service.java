package com.example.demo.service.tmm;

import java.util.List;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeHeader;

public interface TMMA0011Service {
    public List<CommonCodeHeaderResponseDto> get(String commonCodeName, String systemCode);

    public CommonCodeHeader save(CommonCodeHeader cch);

    public CommonCodeHeader update(CommonCodeHeader cch) throws Exception;

    public void delete(String commonCode) throws Exception;
}
