package com.example.demo.service.cmm;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.example.demo.model.cmm.ComCommonPopupInfo;

public interface ComCommonPopupService {
    public ComCommonPopupInfo getCommonPopupInfo(Map<String, String> params);
    public List<JSONObject> getCommonPopupData(Map<String, String> params);
}
