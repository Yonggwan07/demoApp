package com.example.demo.data.entity.cmm;

import java.util.Date;

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
public class CommonCodeDetail extends BaseEntity {
    @Id
    @Schema(description = "sequence")
    private Long seq;
    @Column(nullable = false)
    @Schema(description = "공통코드")
    private String commonCode;
    @Column(nullable = false, unique = true)
    @Schema(description = "세부코드")
    private String commonDetailCode;
    @Schema(description = "세부코드명")
    private String commonDetailCodeName;
    @Schema(description = "세부코드영문명")
    private String commonDetailCodeEnglishName;
    @Schema(description = "생성일")
    private Date createdDate;
    @Schema(description = "폐기일")
    private Date wastedDate;
    @Schema(description = "보조필드1")
    private String refField1;
    @Schema(description = "보조필드2")
    private String refField2;
    @Schema(description = "보조필드3")
    private String refField3;
    @Schema(description = "보조필드4")
    private String refField4;
    @Schema(description = "보조필드5")
    private String refField5;
    @Schema(description = "보조필드6")
    private String refField6;
    @Schema(description = "보조필드7")
    private String refField7;
    @Schema(description = "보조필드8")
    private String refField8;
    @Schema(description = "보조필드9")
    private String refField9;
    @Schema(description = "보조필드10")
    private String refField10;
    @Schema(description = "비고")
    private String note;
    @Schema(description = "정렬순서")
    private int sortOrder;
}
