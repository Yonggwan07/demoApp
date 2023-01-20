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

import com.example.demo.model.tmm.TmCodexh;
import com.example.demo.service.tmm.TMMA0011ServiceImpl;

@WebMvcTest(TMMA0011Controller.class)
public class TMMA0011ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TMMA0011ServiceImpl tmma0011service;

    @Test
    @DisplayName("공통코드 조회 테스트")
    void getTmCodexhTest() throws Exception {

        TmCodexh tmCodexh = new TmCodexh();
        tmCodexh.setId("1");
        tmCodexh.setCOMM_CODE("ACCT_CODE");
        tmCodexh.setCOMM_CDNM("계정과목코드");
        tmCodexh.setSYST_CODE("PAY");

        given(tmma0011service.getTmCodexh("ACCT_CODE", "PAY")).willReturn(Arrays.asList(tmCodexh));
        mockMvc.perform(get("/api/TMMA0011/TmCodexh?COMM_CDNM=ACCT_CODE&SYST_CODE=PAY")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists()).andExpect(jsonPath("$[0].COMM_CODE").exists())
                .andExpect(jsonPath("$[0].COMM_CDNM").exists()).andExpect(jsonPath("$[0].SYST_CODE").exists())
                .andDo(print());
        verify(tmma0011service).getTmCodexh("ACCT_CODE", "PAY");
    }
}
