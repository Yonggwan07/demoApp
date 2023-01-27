package com.example.demo.data.dao.cmm;

import java.util.List;

import com.example.demo.data.entity.cmm.CommonCodeDetail;

public interface CommonCodeDetailDAO {
    List<CommonCodeDetail> findByCommonCodeOrderBySortOrder(String commonCode);
}
