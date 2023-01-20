package com.example.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class SessionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userIdxx; /* 아이디 */
    private String userName; /* 사용자명 */
    private String emplNumb; /* 사원번호 */
    private String emplName; /* 성명 */
    private String usdnCode; /* 내외부구분 */
    private String scrtNumb; /* 비밀번호 */
    private String lginTcnt; /* 로그인시도횟수 */
}
