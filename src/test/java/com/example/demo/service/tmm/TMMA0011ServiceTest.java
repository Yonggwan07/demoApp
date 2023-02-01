package com.example.demo.service.tmm;

import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.data.dao.cmm.CommonCodeHeaderDAO;
import com.example.demo.data.dto.cmm.CommonCodeHeaderResponseDto;

@ExtendWith(MockitoExtension.class)
public class TMMA0011ServiceTest {
    @Mock
    private CommonCodeHeaderDAO commonCodeHeaderDAO;
    @InjectMocks
    private TMMA0011ServiceImpl tmma0011Service;

    @Test
    void getTmCodexhTest() {

        CommonCodeHeaderResponseDto givenCommonCodeHeader = new CommonCodeHeaderResponseDto();
        givenCommonCodeHeader.setCommonCode("ACCT_CODE");
        givenCommonCodeHeader.setCommonCodeName("계정과목코드");
        givenCommonCodeHeader.setSystemCode("PAY");

        given(commonCodeHeaderDAO.findBySearchCondition("ACCT_CODE", "ACCT_CODE", "PAY"))
                .willReturn(List.of(givenCommonCodeHeader));

        List<CommonCodeHeaderResponseDto> commonCodeHeader = tmma0011Service.getCommonCodeHeaders("ACCT_CODE", "PAY");

        Assertions.assertEquals(commonCodeHeader.get(0).getCommonCode(), givenCommonCodeHeader.getCommonCode());
        Assertions.assertEquals(commonCodeHeader.get(0).getCommonCodeName(), givenCommonCodeHeader.getCommonCodeName());
        Assertions.assertEquals(commonCodeHeader.get(0).getSystemCode(), givenCommonCodeHeader.getSystemCode());
    }
}
