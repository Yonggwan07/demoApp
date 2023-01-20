package com.example.demo.model.cmm;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@SuppressWarnings("java:S116")
public class ComCommonPopupInfo {
    private int id;
    private String POPP_CODE;
    private String POPP_NAME;
    private String POPP_CNTT;
    private String AULU_YSNO;
    private String CDRI_YSNO;
    private String SERS_GRDC;
    private String POPP_XDAX;
    private String SECN_SYNX;
}
