package com.example.demo.data.entity.cmm;

import com.example.demo.data.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Id
    @Column(length = 15)
    private String userId;

    @Column(nullable = false, length = 8, unique = true)
    private String userNumber;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 20)
    private String password;
}
