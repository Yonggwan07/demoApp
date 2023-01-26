package com.example.demo.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.data.dto.cmm.UserDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.model.SigninInfo;
import com.example.demo.service.ComAuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/auth")
public class ComAuthController {

    //@Autowired
    //private ComAuthService comAuthService;

    private final ComAuthService comAuthService;

    public ComAuthController(ComAuthService comAuthService) {
        this.comAuthService = comAuthService;
    }

    @PostMapping("signin")
    public ResponseEntity<UserResponseDto> signin(@RequestBody SigninInfo signinInfo, HttpServletRequest request)
            throws AuthenticationException {

        //UserInfo userInfo = null;
        UserResponseDto userResponseDto;

        try {
            UserDto userDto = new UserDto();
            userDto.setUserId(signinInfo.getId());
            userDto.setPassword(signinInfo.getPw());
            userResponseDto = comAuthService.signin(userDto);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        //if (userInfo != null) {
        if (userResponseDto != null) {
            HttpSession session = request.getSession(true);
            //userInfo.setScrtNumb("");
            session.setAttribute("_USER_SESSION_ATTRIBUTE", userResponseDto);
        }

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping("check")
    public ResponseEntity<UserResponseDto> check(
            @SessionAttribute(name = "_USER_SESSION_ATTRIBUTE", required = false) UserResponseDto userInfo) {

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

    // @GetMapping("getMenuList")
    // public ResponseEntity<List<MenuList>> getMenuList() {
    //     return new ResponseEntity<>(comAuthService.getMenuList(), HttpStatus.OK);
    // }
    @GetMapping("getMenuList")
    public List<Menu> getMenuList() {
        return comAuthService.getMenuList();
    }
}
