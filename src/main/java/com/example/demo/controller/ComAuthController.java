package com.example.demo.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import com.example.demo.model.MenuList;
import com.example.demo.model.SigninInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.service.ComAuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("api/auth")
public class ComAuthController {

    @Autowired
    private ComAuthService comAuthService;

    @PostMapping("signin")
    public ResponseEntity<UserInfo> signin(@RequestBody SigninInfo signinInfo, HttpServletRequest request)
            throws AuthenticationException {

        UserInfo userInfo = null;

        try {
            userInfo = comAuthService.signin(signinInfo);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if (userInfo != null) {
            HttpSession session = request.getSession(true);
            userInfo.setScrtNumb("");
            session.setAttribute("_USER_SESSION_ATTRIBUTE", userInfo);
        }

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @GetMapping("check")
    public ResponseEntity<UserInfo> check(
            @SessionAttribute(name = "_USER_SESSION_ATTRIBUTE", required = false) UserInfo userInfo) {

        if (userInfo == null) {
            return new ResponseEntity<>(userInfo, HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        }
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.removeAttribute("_USER_SESSION_ATTRIBUTE");
        return "/";
    }

    @GetMapping("getMenuList")
    public ResponseEntity<List<MenuList>> getMenuList() {
        return new ResponseEntity<>(comAuthService.getMenuList(), HttpStatus.OK);
    }
}
