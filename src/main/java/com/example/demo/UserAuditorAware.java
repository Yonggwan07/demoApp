package com.example.demo;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.data.dto.cmm.UserResponseDto;

import jakarta.servlet.http.HttpSession;

@Component
public class UserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        
        // TODO: JWT

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        UserResponseDto userResponseDto = (UserResponseDto) session.getAttribute("_USER_SESSION_ATTRIBUTE");

        return Optional.of(userResponseDto.getUserId());
    }
}
