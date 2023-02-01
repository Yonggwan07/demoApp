package com.example.demo.service.cmm;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.MenuDAO;
import com.example.demo.data.dto.cmm.SignInResultDto;
import com.example.demo.data.dto.cmm.SignUpResultDto;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.data.entity.cmm.User;
import com.example.demo.data.repository.cmm.UserRepository;
import com.example.demo.lib.CommonResponse;
import com.example.demo.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComAuthServiceImpl implements ComAuthService {

    private final MenuDAO menuDAO;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResultDto signUp(String userId, String password, String username, String role) {
        User user;
        user = User.builder()
                .userId(userId)
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(Collections.singletonList(role.equalsIgnoreCase("ADMIN") ? "ROLE_ADMIN" : "ROLE_USER"))
                .build();

        User savedUser = userRepository.save(user);
        SignUpResultDto signUpResultDto = new SignUpResultDto();

        if (!savedUser.getUsername().isEmpty()) {
            setSuccessResult(signUpResultDto);
        } else {
            setFailResult(signUpResultDto);
        }

        return signUpResultDto;
    }

    @Override
    public SignInResultDto signIn(String userId, String password) throws RuntimeException {

        User user = userRepository.findByUserId(userId);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException();
        }

        SignInResultDto signInResultDto = SignInResultDto.builder()
                .token(jwtTokenProvider.createToken(user.getUserId(), user.getRoles()))
                .build();

        setSuccessResult(signInResultDto);

        return signInResultDto;
    }

    @Override
    public UserResponseDto getUser(String userId) {
        UserResponseDto userResponseDto = new UserResponseDto();
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            userResponseDto.setUserId(user.getUserId());
            userResponseDto.setUsername(user.getUsername());
            userResponseDto
                    .setRoles(user.getRoles().stream().map(role -> String.valueOf(role))
                            .collect(Collectors.joining(", ")));
            return userResponseDto;
        } else {
            return null;
        }
    }

    @Override
    public List<Menu> getMenuList() {
        return menuDAO.selectMenuList();
    }

    private void setSuccessResult(SignUpResultDto result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMessage(CommonResponse.SUCCESS.getMessage());
    }

    private void setFailResult(SignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMessage(CommonResponse.FAIL.getMessage());
    }
}
