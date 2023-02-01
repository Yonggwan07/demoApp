package com.example.demo.service.cmm;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.MenuDAO;
import com.example.demo.data.dto.cmm.UserResponseDto;
import com.example.demo.data.entity.cmm.Menu;
import com.example.demo.data.entity.cmm.User;
import com.example.demo.data.repository.cmm.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComUserServiceImpl implements ComUserService {

    private final UserRepository userRepository;
    private final MenuDAO menuDAO;

    @Override
    public UserResponseDto getUserInfo(String userId) {
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
        return menuDAO.findMenus();
    }
}
