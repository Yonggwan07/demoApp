package com.example.demo.controller.cmm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.cmm.SignInResultDto;
import com.example.demo.data.dto.cmm.SignUpResultDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.cmm.ComAuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/auth")
public class ComAuthController {

    private final ComAuthService comAuthService;
    private final JwtTokenProvider jwtTokenProvider;

    @Operation(summary = "Sign Up")
    @PostMapping("signup")
    public SignUpResultDto signup(
            @Parameter(description = "User ID") @RequestParam(required = true) String userId,
            @Parameter(description = "Password") @RequestParam(required = true) String password,
            @Parameter(description = "User Name") @RequestParam(required = true) String username,
            @Parameter(description = "User Role") @RequestParam(required = true) String role) {
        SignUpResultDto signUpResultDto = comAuthService.signUp(userId, password, username, role);
        return signUpResultDto;
    }

    @Operation(summary = "Sign In")
    @PostMapping("signin")
    public ResponseEntity<SignInResultDto> signin(HttpServletRequest request, HttpServletResponse response)
            throws RuntimeException {
        String authHeader = request.getHeader("Authorization");
        String[] split = authHeader.split(" ");
        String type = split[0];
        String credential = split[1];

        SignInResultDto signInResultDto = null;
        if ("Basic".equalsIgnoreCase(type)) {
            String decoded = new String(Base64Utils.decodeFromString(credential));
            String[] usernameAndPassword = decoded.split(":");

            try {
                signInResultDto = comAuthService.signIn(usernameAndPassword[0], usernameAndPassword[1]);
            } catch (AuthenticationException e) {
                // 사용자명, 암호가 잘못된 경우
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            if (signInResultDto.getCode() == 0) {
                ResponseCookie cookie = ResponseCookie.from("token", signInResultDto.getToken())
                        .maxAge(60 * 60) // 1 hour
                        .path("/")
                        .secure(true)
                        .sameSite("None")
                        .httpOnly(true)
                        .build();
                response.setHeader("Set-Cookie", cookie.toString());
            }
        }

        return new ResponseEntity<>(signInResultDto, HttpStatus.OK);
    }

    @GetMapping("/exception")
    public void exception() throws RuntimeException {
        throw new RuntimeException("Authentication Fail");
    }

    @GetMapping("check")
    public ResponseEntity<UserResponseDto> check(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        if (token == null) {
            return new ResponseEntity<UserResponseDto>(HttpStatus.UNAUTHORIZED);
        }

        String userId = jwtTokenProvider.getUserId(token);
        UserResponseDto userResponseDto = comAuthService.getUser(userId);
        if (userResponseDto == null || userResponseDto.getUserId().isEmpty()) {
            return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.OK);
        }
    }

    @PostMapping("logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "/";
    }

    @GetMapping("getMenuList")
    public List<Menu> getMenuList() {
        return comAuthService.getMenuList();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(RuntimeException e) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", String.valueOf(httpStatus.value()));
        map.put("message", "Authentication Error");

        return new ResponseEntity<>(map, new HttpHeaders(), httpStatus);
    }
}
