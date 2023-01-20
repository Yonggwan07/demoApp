package com.example.demo.controller.cmm;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.cmm.ComCommonPopupInfo;
import com.example.demo.service.cmm.ComCommonPopupService;

@RestController
@RequestMapping("api/comCommonPopup")
public class ComCommonPopupController {

    @Autowired
    private ComCommonPopupService comCommonPopupService;

    @PostMapping("getCommonPopupInfo")
    public ResponseEntity<ComCommonPopupInfo> getCommonPopupInfo(@RequestBody Map<String, String> params) {
        return new ResponseEntity<>(comCommonPopupService.getCommonPopupInfo(params), HttpStatus.OK);
    }

    @PostMapping("getCommonPopupData")
    public ResponseEntity<List<JSONObject>> getCommonPopupData(@RequestBody Map<String, String> params) {
        return new ResponseEntity<>(comCommonPopupService.getCommonPopupData(params), HttpStatus.OK);
    }
}
