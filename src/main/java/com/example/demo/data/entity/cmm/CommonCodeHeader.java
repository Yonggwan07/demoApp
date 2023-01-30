package com.example.demo.data.entity.cmm;

import com.example.demo.data.entity.BaseEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonCodeHeader extends BaseEntity {
    @Id
    @Schema(description = "sequence")
    private Long seq;
    @Column(nullable = false, unique = true)
    @Schema(description = "공통코드")
    private String commonCode;
    @Column(nullable = false)
    @Schema(description = "공통코드명")
    private String commonCodeName;
    @Schema(description = "시스템코드")
    private String systemCode;
    @Schema(description = "코드구분코드")
    private String divisionCode;
    @Schema(description = "세부코드길이")
    private int commonCodeLength;
    @Schema(description = "보조필드설명1")
    private String refFieldDesc1;
    @Schema(description = "보조필드입력형태코드1")
    private String refTypeCode1;
    @Schema(description = "보조필드공통코드1")
    private String refFieldCommonCode1;
    @Schema(description = "보조필드설명2")
    private String refFieldDesc2;
    @Schema(description = "보조필드입력형태코드2")
    private String refTypeCode2;
    @Schema(description = "보조필드공통코드2")
    private String refFieldCommonCode2;
    @Schema(description = "보조필드설명3")
    private String refFieldDesc3;
    @Schema(description = "보조필드입력형태코드3")
    private String refTypeCode3;
    @Schema(description = "보조필드공통코드3")
    private String refFieldCommonCode3;
    @Schema(description = "보조필드설명4")
    private String refFieldDesc4;
    @Schema(description = "보조필드입력형태코드4")
    private String refTypeCode4;
    @Schema(description = "보조필드공통코드4")
    private String refFieldCommonCode4;
    @Schema(description = "보조필드설명5")
    private String refFieldDesc5;
    @Schema(description = "보조필드입력형태코드5")
    private String refTypeCode5;
    @Schema(description = "보조필드공통코드5")
    private String refFieldCommonCode5;
    @Schema(description = "보조필드설명6")
    private String refFieldDesc6;
    @Schema(description = "보조필드입력형태코드6")
    private String refTypeCode6;
    @Schema(description = "보조필드공통코드6")
    private String refFieldCommonCode6;
    @Schema(description = "보조필드설명7")
    private String refFieldDesc7;
    @Schema(description = "보조필드입력형태코드7")
    private String refTypeCode7;
    @Schema(description = "보조필드공통코드7")
    private String refFieldCommonCode7;
    @Schema(description = "보조필드설명8")
    private String refFieldDesc8;
    @Schema(description = "보조필드입력형태코드8")
    private String refTypeCode8;
    @Schema(description = "보조필드공통코드8")
    private String refFieldCommonCode8;
    @Schema(description = "보조필드설명9")
    private String refFieldDesc9;
    @Schema(description = "보조필드입력형태코드9")
    private String refTypeCode9;
    @Schema(description = "보조필드공통코드9")
    private String refFieldCommonCode9;
    @Schema(description = "보조필드설명10")
    private String refFieldDesc10;
    @Schema(description = "보조필드입력형태코드10")
    private String refTypeCode10;
    @Schema(description = "보조필드공통코드10")
    private String refFieldCommonCode10;
    @Schema(description = "비고")
    private String note;
    @Schema(description = "초기세팅여부")
    private boolean isInitialized;
}
