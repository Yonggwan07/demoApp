package com.example.demo.data.repository.cmm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
