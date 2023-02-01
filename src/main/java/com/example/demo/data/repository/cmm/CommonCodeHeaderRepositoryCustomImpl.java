package com.example.demo.data.repository.cmm;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.data.entity.cmm.CommonCodeHeader;
import com.example.demo.data.entity.cmm.QCommonCodeHeader;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.example.demo.data.entity.cmm.QCommonCodeHeader.commonCodeHeader;

@Component
public class CommonCodeHeaderRepositoryCustomImpl extends QuerydslRepositorySupport
        implements CommonCodeHeaderRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QCommonCodeHeader subHeader = new QCommonCodeHeader("subHeader");

    public CommonCodeHeaderRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(CommonCodeHeader.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<CommonCodeHeaderResponseDto> findBySearchCondition(String commonCode, String commonCodeName,
            String systemCode) {
        List<CommonCodeHeaderResponseDto> selected = queryFactory.select(Projections.fields(CommonCodeHeaderResponseDto.class,
                commonCodeHeader.id, commonCodeHeader.commonCode, commonCodeHeader.commonCodeName,
                commonCodeHeader.systemCode, commonCodeHeader.divisionCode, commonCodeHeader.commonCodeLength,
                commonCodeHeader.note, commonCodeHeader.isInitialized,
                commonCodeHeader.refFieldDesc1, commonCodeHeader.refTypeCode1, commonCodeHeader.refFieldCommonCode1,
                commonCodeHeader.refFieldDesc2, commonCodeHeader.refTypeCode2, commonCodeHeader.refFieldCommonCode2,
                commonCodeHeader.refFieldDesc3, commonCodeHeader.refTypeCode3, commonCodeHeader.refFieldCommonCode3,
                commonCodeHeader.refFieldDesc4, commonCodeHeader.refTypeCode4, commonCodeHeader.refFieldCommonCode4,
                commonCodeHeader.refFieldDesc5, commonCodeHeader.refTypeCode5, commonCodeHeader.refFieldCommonCode5,
                commonCodeHeader.refFieldDesc6, commonCodeHeader.refTypeCode6, commonCodeHeader.refFieldCommonCode6,
                commonCodeHeader.refFieldDesc7, commonCodeHeader.refTypeCode7, commonCodeHeader.refFieldCommonCode7,
                commonCodeHeader.refFieldDesc8, commonCodeHeader.refTypeCode8, commonCodeHeader.refFieldCommonCode8,
                commonCodeHeader.refFieldDesc9, commonCodeHeader.refTypeCode9, commonCodeHeader.refFieldCommonCode9,
                commonCodeHeader.refFieldDesc10, commonCodeHeader.refTypeCode10,
                commonCodeHeader.refFieldCommonCode10,
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode1)),
                        "refFieldCommonCodeName1"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode2)),
                        "refFieldCommonCodeName2"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode3)),
                        "refFieldCommonCodeName3"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode4)),
                        "refFieldCommonCodeName4"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode5)),
                        "refFieldCommonCodeName5"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode6)),
                        "refFieldCommonCodeName6"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode7)),
                        "refFieldCommonCodeName7"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode8)),
                        "refFieldCommonCodeName8"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode9)),
                        "refFieldCommonCodeName9"),
                ExpressionUtils.as(
                        JPAExpressions.select(subHeader.commonCodeName).from(subHeader)
                                .where(subHeader.commonCode.eq(commonCodeHeader.refFieldCommonCode10)),
                        "refFieldCommonCodeName10")))
                .from(commonCodeHeader).where(searchCondition(commonCode, commonCodeName, systemCode))
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
