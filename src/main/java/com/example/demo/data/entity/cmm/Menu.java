package com.example.demo.data.entity.cmm;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Menu {
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
