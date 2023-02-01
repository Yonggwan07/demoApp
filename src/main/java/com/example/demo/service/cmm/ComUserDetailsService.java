package com.example.demo.service.cmm;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.security.ComUserDetails;

public interface ComUserDetailsService {
    ComUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException;
}
