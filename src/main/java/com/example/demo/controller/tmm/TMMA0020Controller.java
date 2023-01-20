package com.example.demo.controller.tmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.tmm.TmMessxm;
import com.example.demo.service.tmm.TMMA0020Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TMMA0020 - 메시지관리")
@RestController
@RequestMapping("api/TMMA0020")
public class TMMA0020Controller {

    @Autowired
    private TMMA0020Service tmma0020Service;

    @Operation(summary = "메시지 조회")
    @GetMapping("TmMessxm")
    public List<TmMessxm> getTmMessxm(
            @Parameter(description = "메시지내용") @RequestParam(required = false) String MSGE_CNTT) {
        return tmma0020Service.getTmMessxm(MSGE_CNTT);
    }
}
