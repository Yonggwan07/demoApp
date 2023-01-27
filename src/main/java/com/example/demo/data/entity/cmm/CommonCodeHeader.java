package com.example.demo.data.entity.cmm;

import java.util.List;

import com.example.demo.data.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonCodeHeader extends BaseEntity {
    @Id
    @Column(length = 10)
    private String commonCode;
    private String commonCodeName;
    private String systemCode;
    private String divisionCode;
    private int commonCodeLength;
    private String refFieldDesc1;
    private String refTypeCode1;
    private String refFieldCommonCode1;
    private String refFieldDesc2;
    private String refTypeCode2;
    private String refFieldCommonCode2;
    private String refFieldDesc3;
    private String refTypeCode3;
    private String refFieldCommonCode3;
    private String refFieldDesc4;
    private String refTypeCode4;
    private String refFieldCommonCode4;
    private String refFieldDesc5;
    private String refTypeCode5;
    private String refFieldCommonCode5;
    private String refFieldDesc6;
    private String refTypeCode6;
    private String refFieldCommonCode6;
    private String refFieldDesc7;
    private String refTypeCode7;
    private String refFieldCommonCode7;
    private String refFieldDesc8;
    private String refTypeCode8;
    private String refFieldCommonCode8;
    private String refFieldDesc9;
    private String refTypeCode9;
    private String refFieldCommonCode9;
    private String refFieldDesc10;
    private String refTypeCode10;
    private String refFieldCommonCode10;
    private String note;

    //@OneToMany
    //@JoinColumn(name = "common_code")
    //@OrderBy("sort_order")
    //private List<CommonCodeDetail> commonCodeDetails;
}
