package com.example.demo.data.entity.cmm;

import com.example.demo.data.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity {
    @Id
    @Column(length = 9)
    private String menuId;

    @Column(length = 50)
    private String menuName;

    @Column(length = 6)
    private String systemCode;

    private int menuLevel;

    @Column(length = 9)
    private String upperMenuId;

    @Column(length = 12)
    private String programId;

    private boolean isMenuTree;

    private boolean isUse;

    private boolean isDevComplete;

    private String sortId;
}
