package com.example.demo.data.entity.cmm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.security.ComUserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements ComUserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false, length = 15, unique = true)
    private String userId;

    @Column(nullable = false, length = 20)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false, length = 20)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public boolean isAccountNonExpired() {
        return false;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public boolean isAccountNonLocked() {
        return false;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public boolean isEnabled() {
        return true;
    }
}
