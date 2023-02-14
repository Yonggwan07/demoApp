package com.example.demo.data.entity.cmm;

import com.example.demo.data.entity.BaseEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id")
    private Long id;
    @Column(nullable = false, unique = true)
    @Schema(description = "메시지코드")
    private String messageCode;
    @Schema(description = "메시지내용")
    private String messageContent;
    @Schema(description = "메시지영문내용")
    private String messageEnglishContent;
    @Schema(description = "메시지종류코드")
    private String messageTypeCode;
    @Schema(description = "메시지구분코드")
    private String messageDivisionCode;
}
