package com.example.demo.controller.tmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.tmm.TmCodexd;
import com.example.demo.model.tmm.TmCodexh;
import com.example.demo.service.tmm.TMMA0012Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TMMA0012 - 세부코드관리")
@RestController
@RequestMapping("api/TMMA0012")
public class TMMA0012Controller {

    @Autowired
    private TMMA0012Service tmma0012Service;

    @Operation(summary = "공통코드 조회")
    @GetMapping("TmCodexh")
    public List<TmCodexh> getTmCodexh(
            @Parameter(description = "공통코드/명") @RequestParam(required = false) String COMM_CDNM,
            @Parameter(description = "시스템코드") @RequestParam(required = false) String SYST_CODE) {
        return tmma0012Service.getTmCodexh(COMM_CDNM, SYST_CODE);
    }

    @Operation(summary = "세부코드 조회")
    @GetMapping("TmCodexd")
    public List<TmCodexd> getTmCodexd(@Parameter(description = "공통코드") @RequestParam String COMM_CODE) {
        return tmma0012Service.getTmCodexd(COMM_CODE);
    }
}
