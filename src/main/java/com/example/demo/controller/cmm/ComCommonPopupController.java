package com.example.demo.controller.cmm;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.cmm.ComCommonPopupInfo;
import com.example.demo.service.cmm.ComCommonPopupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "공통팝업")
@RestController
@RequestMapping("api/commonPopup")
public class ComCommonPopupController {

    @Autowired
    private ComCommonPopupService comCommonPopupService;

    @Operation(summary = "공통팝업 정보 조회")
    @GetMapping("info")
    public ResponseEntity<ComCommonPopupInfo> getCommonPopupInfo(
            @Parameter(description = "팝업 ID") @RequestParam String popupId) {
        return new ResponseEntity<>(comCommonPopupService.getCommonPopupInfo(popupId), HttpStatus.OK);
    }

    @Operation(summary = "공통팝업 데이터 조회")
    @GetMapping("data")
    public ResponseEntity<List<JSONObject>> getCommonPopupData(
            @Parameter(description = "팝업 XDA") @RequestParam String POPP_XDAX,
            @Parameter(description = "공통코드 명") @RequestParam(required = false) String COMM_CDNM) {
        return new ResponseEntity<>(comCommonPopupService.getCommonPopupData(POPP_XDAX, COMM_CDNM), HttpStatus.OK);
    }
}
