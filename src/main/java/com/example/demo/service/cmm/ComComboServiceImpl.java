package com.example.demo.service.cmm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.CommonCodeDetailDAO;
import com.example.demo.data.entity.cmm.CommonCodeDetail;

@Service
public class ComComboServiceImpl implements ComComboService {
    private final CommonCodeDetailDAO commonCodeDetailDAO;
    // private final CommonCodeHeaderDAO commonCodeHeaderDAO;

    public ComComboServiceImpl(CommonCodeDetailDAO commonCodeDetailDAO) {
        this.commonCodeDetailDAO = commonCodeDetailDAO;
    }

    @Override
    public JSONObject getCombo(List<Map<String, String>> params) {

        Map<String, Object> map = new HashMap<>();

        for (Map<String, String> comboItem : params) {
            List<CommonCodeDetail> selected = commonCodeDetailDAO
                    .findByCommonCodeOrderBySortOrder(comboItem.get("commCode"));
            map.put(comboItem.get("commCode"), selected);
        }

        return new JSONObject(map);
    }
}
