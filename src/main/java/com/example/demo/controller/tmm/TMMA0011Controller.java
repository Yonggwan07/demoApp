package com.example.demo.controller.tmm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.service.tmm.TMMA0011Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TMMA0011 - 공통코드관리")
@RestController
@RequestMapping("api/TMMA0011")
public class TMMA0011Controller {

    @Autowired
    private TMMA0011Service tmma0010Service;

    @Operation(summary = "공통코드 조회")
    @GetMapping("commonCodeHeader")
    public List<CommonCodeHeaderResponseDto> getTmCodexh(
            @Parameter(description = "공통코드/명") @RequestParam(required = false) String commonCodeName,
            @Parameter(description = "시스템코드") @RequestParam(required = false) String systemCode) {
        return tmma0010Service.getCommonCodeHeaders(commonCodeName, systemCode);
    }

    @PostMapping("save00")
    public int save00(@RequestBody List<Map<String, String>> data) {
        return tmma0010Service.save00(data);
    }
}
