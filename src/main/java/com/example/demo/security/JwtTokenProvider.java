package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.service.cmm.ComUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private final ComUserDetailsService comUserDetailsService;

    private String secretKey = "6F425FF9B522981DCC9FF78F854DB";
    private final long tokenValidMillisecond = 1000L * 60 * 60;
    private SecretKey generatedSecretKey;

    @PostConstruct
    protected void init() {
        generatedSecretKey = Keys.hmacShaKeyFor(Base64.getEncoder().encode(secretKey.getBytes(StandardCharsets.UTF_8)));
    }

    public String createToken(String userId, List<String> roles) {

        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("roles", roles);
        Date now = new Date();

        String token = Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .signWith(generatedSecretKey, SignatureAlgorithm.HS256).compact();

        return token;
    }

    public String getUserId(String token) {
        String info = Jwts.parserBuilder().setSigningKey(generatedSecretKey).build().parseClaimsJws(token).getBody()
                .getSubject();
        return info;
    }

    public Authentication getAuthentication(String token) throws AuthenticationException {
        ComUserDetails comUserDetails = comUserDetailsService.loadUserByUserId(this.getUserId(token));
        return new UsernamePasswordAuthenticationToken(comUserDetails, "", comUserDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public boolean validateToken(String token) {
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parserBuilder().setSigningKey(generatedSecretKey).build().parseClaimsJws(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return !claims.getBody().getExpiration().before(new Date());
    }
}
