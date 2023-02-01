package com.example.demo;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.ComAuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAuditorAware implements AuditorAware<String> {

    private final JwtTokenProvider jwtTokenProvider;
    private final ComAuthService comAuthService;

    @Override
    public Optional<String> getCurrentAuditor() {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String token = jwtTokenProvider.resolveToken(attr.getRequest());
        String userId = jwtTokenProvider.getUserId(token);
        UserResponseDto userResponseDto = comAuthService.getUser(userId);

        return Optional.of(userResponseDto.getUserId());
    }
}
