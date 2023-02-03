package com.example.demo.service.cmm;

import java.util.List;

import org.json.simple.JSONObject;

import com.example.demo.model.cmm.ComCommonPopupInfo;

public interface ComCommonPopupService {
    public ComCommonPopupInfo getCommonPopupInfo(String params);
    public List<JSONObject> getCommonPopupData(String POPP_XDAX, String COMM_CDNM);
}
