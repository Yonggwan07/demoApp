package com.example.demo.service.cmm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.mapper.cmm.ComComboMapper;
import com.example.demo.model.cmm.ComCombo;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComComboServiceImpl implements ComComboService {

    @Autowired
    private ComComboMapper comComboMapper;

    @Override
    public JSONObject getCombo(List<Map<String, String>> params) {

        Map<String, List<ComCombo>> map = new HashMap<>();

        for (Map<String, String> comboItem : params) {

            List<ComCombo> codeData = comComboMapper.getCombo(comboItem);
            int id = 0;
            for (ComCombo obj : codeData) {
                obj.setId(id++);
            }

            map.put(comboItem.get("commCode"), codeData);
        }

        return new JSONObject(map);
    }

    /* 
    public JSONArray getCombo(List<Map<String, String>> params) {

    Map<String, Object> map = new HashMap<>();
    JSONArray list = new JSONArray();

    for (Map<String, String> comboItem : params) {

        List<ComCombo> codeData = comComboMapper.getCombo(comboItem);
        int id = 0;
        for (ComCombo obj : codeData) {
            obj.setId(id++);
        }

        map.put("commCode", comboItem.get("commCode"));
        map.put("commData", codeData);

        JSONObject jsonObj = new JSONObject(map);
        list.add(jsonObj);
    }

    return list;
}
*/
}
