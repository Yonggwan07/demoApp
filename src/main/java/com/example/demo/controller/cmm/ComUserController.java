package com.example.demo.controller.cmm;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.cmm.ComUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Tag(name = "사용자 정보")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class ComUserController {
    private final ComUserService comUserService;
    private final JwtTokenProvider jwtTokenProvider;
    
    @Operation(summary = "현재 로그인된 사용자의 정보 조회")
    @GetMapping
    public UserResponseDto getUserInfo(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        String userId = jwtTokenProvider.getUserId(token);
        return comUserService.getUserInfo(userId);
    }

    @Operation(summary = "현재 로그인된 사용자의 메뉴리스트 조회")
    @GetMapping("menu")
    public List<Menu> getMenuList() {
        return comUserService.getMenuList();
    }
}
