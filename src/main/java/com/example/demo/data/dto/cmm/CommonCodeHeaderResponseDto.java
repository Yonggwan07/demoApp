package com.example.demo.data.dto.cmm;

import com.example.demo.data.entity.cmm.CommonCodeHeader;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonCodeHeaderResponseDto extends CommonCodeHeader {
    @Schema(description = "보조1필드공통코드명")
    private String refFieldCommonCodeName1;
    @Schema(description = "보조2필드공통코드명")
    private String refFieldCommonCodeName2;
    @Schema(description = "보조3필드공통코드명")
    private String refFieldCommonCodeName3;
    @Schema(description = "보조4필드공통코드명")
    private String refFieldCommonCodeName4;
    @Schema(description = "보조5필드공통코드명")
    private String refFieldCommonCodeName5;
    @Schema(description = "보조6필드공통코드명")
    private String refFieldCommonCodeName6;
    @Schema(description = "보조7필드공통코드명")
    private String refFieldCommonCodeName7;
    @Schema(description = "보조8필드공통코드명")
    private String refFieldCommonCodeName8;
    @Schema(description = "보조9필드공통코드명")
    private String refFieldCommonCodeName9;
    @Schema(description = "보조10필드공통코드명")
    private String refFieldCommonCodeName10;
}
