package com.example.demo.controller.tmm;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.WithUser;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;
import com.example.demo.service.tmm.TMMA0011ServiceImpl;

@WebMvcTest(TMMA0011Controller.class)
public class TMMA0011ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TMMA0011ServiceImpl tmma0011service;

    @Test
    @WithUser
    @DisplayName("공통코드 조회 테스트")
    void getTmCodexhTest() throws Exception {
        CommonCodeHeaderResponseDto cchrDto = new CommonCodeHeaderResponseDto();
        cchrDto.setCommonCode("ACCT_CODE");
        cchrDto.setCommonCodeName("계정과목코드");
        cchrDto.setSystemCode("PAY");

        given(tmma0011service.get("ACCT_CODE", "PAY")).willReturn(Arrays.asList(cchrDto));
        mockMvc.perform(get("/api/TMMA0011/commonCodeHeader?commonCodeName=ACCT_CODE&systemCode=PAY")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].commonCode").exists()).andExpect(jsonPath("$[0].commonCodeName").exists())
                .andExpect(jsonPath("$[0].systemCode").exists())
                .andDo(print());
        verify(tmma0011service).get("ACCT_CODE", "PAY");
    }
}
