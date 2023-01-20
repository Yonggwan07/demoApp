package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    
    @Value("${server.servlet.session.timeout}")
    private int sessionTime;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(sessionTime);
    }
}
