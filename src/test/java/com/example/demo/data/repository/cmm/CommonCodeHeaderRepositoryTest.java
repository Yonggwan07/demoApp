package com.example.demo.data.repository.cmm;

import static com.example.demo.data.entity.cmm.QCommonCodeHeader.commonCodeHeader;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
public class CommonCodeHeaderRepositoryTest {
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    void commonCodeHeaderTest() {

        List<CommonCodeHeader> selected = jpaQueryFactory.select(commonCodeHeader).from(commonCodeHeader)
                .where(searchCondition("코드", "코드", "PAY"))
                .orderBy(commonCodeHeader.commonCode.asc()).fetch();

        for (CommonCodeHeader commonCodeHeader : selected) {
            System.out.println(commonCodeHeader.getCommonCode());
            System.out.println(commonCodeHeader.getCommonCodeName());
            System.out.println(commonCodeHeader.getSystemCode());
        }
    }

    private BooleanBuilder searchCondition(String commonCode, String commonCodeName, String systemCode) {
        BooleanBuilder bb = new BooleanBuilder();
        if (!StringUtils.isNullOrEmpty(commonCode)) {
            bb.or(commonCodeHeader.commonCode.contains(commonCode));
        }
        if (!StringUtils.isNullOrEmpty(commonCodeName)) {
            bb.or(commonCodeHeader.commonCodeName.contains(commonCodeName));
        }
        if (!StringUtils.isNullOrEmpty(commonCodeName)) {
            bb.and(commonCodeHeader.systemCode.eq(systemCode));
        }

        return bb;
    }
}
