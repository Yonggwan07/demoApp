package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MenuList implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String menuLevl;
    private String menuIdxx;
    private String devcYsno;
    private String menuName;
    private String mnutYsno;
    private String upmeIdxx;
    private String upmeName;
    private String progIdxx;
    private String progPath;
    private String userAuth;
    private String athrLevl;
    private String systCode;
    private String sortIdxx;
}
