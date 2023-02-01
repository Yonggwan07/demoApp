package com.example.demo.service.cmm;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.data.repository.cmm.UserRepository;
import com.example.demo.security.ComUserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComUserDetailsServiceImpl implements ComUserDetailsService {
    private final UserRepository userRepository;

    public ComUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        return userRepository.findByUserId(userId);
    }
}
