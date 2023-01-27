package com.example.demo.service.cmm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.entity.cmm.CommonCodeHeader;

@Service
public class ComComboServiceImpl implements ComComboService {
    // private final CommonCodeDetailDAO commonCodeDetailDAO;
    private final CommonCodeHeaderDAO commonCodeHeaderDAO;

    public ComComboServiceImpl(CommonCodeHeaderDAO commonCodeHeaderDAO) {
        this.commonCodeHeaderDAO = commonCodeHeaderDAO;
    }

    @Override
    public JSONObject getCombo(List<Map<String, String>> params) {

        Map<String, Object> map = new HashMap<>();

        for (Map<String, String> comboItem : params) {
            Optional<CommonCodeHeader> selected = commonCodeHeaderDAO
                    .selectCommonCode(comboItem.get("commCode"));
            if (selected.isPresent()) {
                map.put(comboItem.get("commCode"), selected.get().getCommonCodeDetails());
            }
        }

        return new JSONObject(map);
    }
}
