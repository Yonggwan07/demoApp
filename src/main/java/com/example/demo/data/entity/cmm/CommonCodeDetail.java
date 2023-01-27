package com.example.demo.data.entity.cmm;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(CommonCodeDetailPK.class)
public class CommonCodeDetail {
    @Id
    @Column(name = "common_code")
    private String commonCode;
    @Id
    private String commonDetailCode;
    private String commonDetailCodeName;
    private String commonDetailCodeEnglishName;
    private Date createdDate;
    private Date wastedDate;
    private String refField1;
    private String refField2;
    private String refField3;
    private String refField4;
    private String refField5;
    private String refField6;
    private String refField7;
    private String refField8;
    private String refField9;
    private String refField10;
    private String note;
    private int sortOrder;
}
