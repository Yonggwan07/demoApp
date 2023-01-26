package com.example.demo.data.entity.cmm;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @Column(length = 15)
    private String userId;

    @Column(nullable = false, length = 8, unique = true)
    private String userNumber;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 20)
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
