package com.example.demo.controller.cmm;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.cmm.ComComboService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "공통콤보")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/combo")
public class ComComboController {
    private final ComComboService comComboService;

    @Operation(summary = "공통콤보 조회")
    @GetMapping
    public JSONObject getCombo(@Parameter(description = "공통코드") @RequestParam(value = "codes") String[] codes) {
        return comComboService.getCombo(codes);
    }
}
