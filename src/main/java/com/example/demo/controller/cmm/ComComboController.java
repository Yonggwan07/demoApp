package com.example.demo.controller.cmm;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.cmm.ComComboService;

@RestController
@RequestMapping("api/comCombo")
public class ComComboController {
    private final ComComboService comComboService;

    public ComComboController(ComComboService comComboService) {
        this.comComboService = comComboService;
    }

    @PostMapping("getCombo")
    public JSONObject getCombo(@RequestBody List<Map<String, String>> params) {
        return comComboService.getCombo(params);
    }
}
