package com.example.demo.controller.cmm;

import java.util.List;
import java.util.Map;

import com.example.demo.service.cmm.ComComboService;

import jakarta.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comCombo")
public class ComComboController {

    @Autowired
    private ComComboService comComboService;

    @PostMapping("getCombo")
    public ResponseEntity<JSONObject> getCombo(@RequestBody List<Map<String, String>> params,
            HttpServletRequest request) {
        return new ResponseEntity<>(comComboService.getCombo(params), HttpStatus.OK);
    }
}
