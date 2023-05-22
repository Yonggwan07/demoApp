package com.example.demo.controller.tmm;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeDetail;
import com.example.demo.service.tmm.TMMA0012Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "TMMA0012 - 세부코드관리")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/tmma0012")
public class TMMA0012Controller {

    private final TMMA0012Service tmma0012Service;

    @Operation(summary = "공통코드 조회")
    @GetMapping("header")
    public List<CommonCodeHeaderResponseDto> getHeader(
            @Parameter(description = "공통코드/명") @RequestParam(required = false) String commonCodeName,
            @Parameter(description = "시스템코드") @RequestParam(required = false) String systemCode) {
        return tmma0012Service.getHeader(commonCodeName, systemCode);
    }

    @Operation(summary = "세부코드 조회")
    @GetMapping("detail")
    public List<CommonCodeDetail> getDetail(@Parameter(description = "공통코드") @RequestParam String commonCode) {
        return tmma0012Service.getDetail(commonCode);
    }
}
