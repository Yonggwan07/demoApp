package com.example.demo.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface ComUserDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getUserId();

    String getPassword();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
