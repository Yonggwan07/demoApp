package com.example.demo.service.tmm;

import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.mapper.tmm.TMMA0011Mapper;
import com.example.demo.model.tmm.TmCodexh;

public class TMMA0011ServiceTest {
    private TMMA0011Mapper tmma0011Mapper = Mockito.mock(TMMA0011Mapper.class);
    private TMMA0011ServiceImpl tmma0011Service;

    @BeforeEach
    public void setUpTest() {
        tmma0011Service = new TMMA0011ServiceImpl(tmma0011Mapper);
    }

    @Test
    void getTmCodexhTest() {

        TmCodexh givenTmCodexh = new TmCodexh();
        givenTmCodexh.setCOMM_CODE("ACCT_CODE");
        givenTmCodexh.setCOMM_CDNM("계정과목코드");
        givenTmCodexh.setSYST_CODE("PAY");

        Mockito.when(tmma0011Mapper.getTmCodexh("ACCT_CODE", "PAY")).thenReturn(Arrays.asList(givenTmCodexh));

        List<TmCodexh> tmCodexh = tmma0011Service.getTmCodexh("ACCT_CODE", "PAY");

        Assertions.assertEquals(tmCodexh.get(0).getCOMM_CODE(), givenTmCodexh.getCOMM_CODE());
        Assertions.assertEquals(tmCodexh.get(0).getCOMM_CDNM(), givenTmCodexh.getCOMM_CDNM());
        Assertions.assertEquals(tmCodexh.get(0).getSYST_CODE(), givenTmCodexh.getSYST_CODE());

        verify(tmma0011Mapper).getTmCodexh("ACCT_CODE", "PAY");
    }
}
