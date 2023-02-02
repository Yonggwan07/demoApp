package com.example.demo.data.dao.cmm.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.example.demo.data.repository.cmm.CommonCodeHeaderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CommonCodeHeaderDAOImpl implements CommonCodeHeaderDAO {
    private final CommonCodeHeaderRepository repo;

    @Override
    public List<CommonCodeHeaderResponseDto> findBySearchCondition(String commonCode, String commonCodeName,
            String systemCode) {
        return repo.findBySearchCondition(commonCode, commonCodeName, systemCode);
    }

    @Override
    public CommonCodeHeader insertCommonCodeHeader(CommonCodeHeader cch) {
        return repo.save(cch);
    }

    @Override
    public CommonCodeHeader updateCommonCodeHeader(CommonCodeHeader cch) throws Exception {
        Optional<CommonCodeHeader> selected = repo.findById(cch.getId());
        CommonCodeHeader updated;
        if (selected.isPresent()) {
            CommonCodeHeader curr = selected.get();
            curr.setNote(cch.getNote());
            updated = repo.save(curr);
        } else {
            throw new Exception();
        }

        return updated;
    }

    @Override
    public void deleteCommonCodeHeader(String commonCode) throws Exception {
        Optional<CommonCodeHeader> selected = repo.findByCommonCode(commonCode);
        if (selected.isPresent()) {
            CommonCodeHeader cch = selected.get();
            repo.delete(cch);
        } else {
            throw new Exception();
        }
    }
}
