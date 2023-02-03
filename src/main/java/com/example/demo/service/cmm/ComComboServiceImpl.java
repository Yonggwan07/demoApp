package com.example.demo.service.cmm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.CommonCodeDetailDAO;
import com.example.demo.data.entity.cmm.CommonCodeDetail;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComComboServiceImpl implements ComComboService {
    private final CommonCodeDetailDAO commonCodeDetailDAO;

    @Override
    public JSONObject getCombo(String[] params) {

        Map<String, Object> map = new HashMap<>();

        for (String code : params) {
            List<CommonCodeDetail> selected = commonCodeDetailDAO.findByCommonCodeOrderBySortOrder(code);
            map.put(code, selected);
        }

        return new JSONObject(map);
    }
}
