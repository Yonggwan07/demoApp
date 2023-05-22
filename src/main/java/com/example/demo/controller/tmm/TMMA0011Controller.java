package com.example.demo.controller.tmm;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.example.demo.service.tmm.TMMA0011Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "TMMA0011 - 공통코드관리")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/tmma0011")
public class TMMA0011Controller {

    private final TMMA0011Service tmma0011Service;

    @Operation(summary = "공통코드 조회")
    @GetMapping
    public List<CommonCodeHeaderResponseDto> get(
            @Parameter(description = "공통코드/명") @RequestParam(required = false) String commonCodeName,
            @Parameter(description = "시스템코드") @RequestParam(required = false) String systemCode) {
        return tmma0011Service.get(commonCodeName, systemCode);
    }

    @Operation(summary = "공통코드 저장")
    @PostMapping
    public ResponseEntity<CommonCodeHeader> save(@RequestBody CommonCodeHeader cch) throws RuntimeException {
        return new ResponseEntity<>(tmma0011Service.save(cch), HttpStatus.OK);
    }

    @Operation(summary = "공통코드 수정")
    @PutMapping
    public ResponseEntity<CommonCodeHeader> update(@RequestBody CommonCodeHeader cch) throws Exception {
        return new ResponseEntity<>(tmma0011Service.update(cch), HttpStatus.OK);
    }

    @Operation(summary = "공통코드 삭제")
    @DeleteMapping
    public HttpStatus delete(@Parameter(description = "공통코드") @RequestParam String commonCode) throws Exception {
        tmma0011Service.delete(commonCode);
        return HttpStatus.OK;
    }

}
