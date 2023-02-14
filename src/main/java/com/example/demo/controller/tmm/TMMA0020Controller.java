package com.example.demo.controller.tmm;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entity.cmm.Message;
import com.example.demo.service.tmm.TMMA0020Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "TMMA0020 - 메시지관리")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/TMMA0020")
public class TMMA0020Controller {

    private final TMMA0020Service tmma0020Service;

    @Operation(summary = "메시지 조회")
    @GetMapping
    public List<Message> get(
            @Parameter(description = "메시지내용") @RequestParam(required = false) String messageContent) {
        return tmma0020Service.get(messageContent);
    }
}
