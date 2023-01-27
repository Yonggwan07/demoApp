package com.example.demo.data.repository.cmm;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.CommonCodeDetail;

public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetail, String> {
    Optional<List<CommonCodeDetail>> findByCommonCodeOrderBySortOrder(String commonCode);
}
