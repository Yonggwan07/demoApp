package com.example.demo.data.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    @Schema(description = "생성일자")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    @Schema(description = "생성자")
    private String createdBy;

    @LastModifiedDate
    @Schema(description = "수정일자")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Schema(description = "수정자")
    private String updatedBy;
}
