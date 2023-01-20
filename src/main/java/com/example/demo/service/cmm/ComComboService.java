package com.example.demo.service.cmm;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

public interface ComComboService {
    public JSONObject getCombo(List<Map<String, String>> params);
}
