package com.example.demo.data.repository.cmm;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.util.StringUtils;

import static com.example.demo.data.entity.cmm.QCommonCodeHeader.commonCodeHeader;

@Component
public class CommonCodeHeaderRepositoryCustomImpl extends QuerydslRepositorySupport
        implements CommonCodeHeaderRepositoryCustom {

    public CommonCodeHeaderRepositoryCustomImpl() {
        super(CommonCodeHeader.class);
    }

    @Override
    public List<CommonCodeHeader> findBySearchCondition(String commonCode, String commonCodeName, String systemCode) {
        List<CommonCodeHeader> selected = from(commonCodeHeader)
                .where(searchCondition(commonCode, commonCodeName, systemCode))
                .orderBy(commonCodeHeader.commonCode.asc()).fetch();

        return selected;
    }

    private BooleanBuilder searchCondition(String commonCode, String commonCodeName, String systemCode) {
        BooleanBuilder bb = new BooleanBuilder();
        if (!StringUtils.isNullOrEmpty(commonCode)) {
            bb.or(commonCodeHeader.commonCode.contains(commonCode));
        }
        if (!StringUtils.isNullOrEmpty(commonCodeName)) {
            bb.or(commonCodeHeader.commonCodeName.contains(commonCodeName));
        }
        if (!StringUtils.isNullOrEmpty(systemCode)) {
            bb.and(commonCodeHeader.systemCode.eq(systemCode));
        }

        return bb;
    }
}
