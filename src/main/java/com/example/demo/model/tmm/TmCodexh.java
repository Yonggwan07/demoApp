package com.example.demo.model.tmm;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "공통코드")
@Getter
@Setter
@ToString
@Component
@SuppressWarnings("java:S116")
public class TmCodexh {
    private String id;

    @JsonProperty("COMM_CODE")
    @Schema(description = "공통코드")
    private String COMM_CODE;

    @JsonProperty("COMM_CDNM")
    @Schema(description = "공통코드명")
    private String COMM_CDNM;

    @JsonProperty("SYST_CODE")
    @Schema(description = "시스템코드")
    private String SYST_CODE;

    @JsonProperty("CDGB_CODE")
    @Schema(description = "코드구분코드")
    private String CDGB_CODE;

    @JsonProperty("COCD_LNTH")
    @Schema(description = "세부코드길이")
    private String COCD_LNTH;

    @JsonProperty("RE1F_DESC")
    @Schema(description = "보조1필드설명")
    private String RE1F_DESC;

    @JsonProperty("RE1T_CODE")
    @Schema(description = "보조1필드입력형태코드")
    private String RE1T_CODE;

    @JsonProperty("RE1F_CMCD")
    @Schema(description = "보조1필드공통코드")
    private String RE1F_CMCD;

    @JsonProperty("RE1F_CMNM")
    @Schema(description = "보조1필드공통코드명")
    private String RE1F_CMNM;

    @JsonProperty("RE1O_CODE")
    @Schema(description = "보조1필드출력형태코드")
    private String RE1O_CODE;

    @JsonProperty("RE2F_DESC")
    @Schema(description = "보조2필드설명")
    private String RE2F_DESC;

    @JsonProperty("RE2T_CODE")
    @Schema(description = "보조2필드입력형태코드")
    private String RE2T_CODE;

    @JsonProperty("RE2F_CMCD")
    @Schema(description = "보조2필드공통코드")
    private String RE2F_CMCD;

    @JsonProperty("RE2F_CMNM")
    @Schema(description = "보조2필드공통코드명")
    private String RE2F_CMNM;

    @JsonProperty("RE2O_CODE")
    @Schema(description = "보조2필드출력형태코드")
    private String RE2O_CODE;

    @JsonProperty("RE3F_DESC")
    @Schema(description = "보조3필드설명")
    private String RE3F_DESC;

    @JsonProperty("RE3T_CODE")
    @Schema(description = "보조3필드입력형태코드")
    private String RE3T_CODE;

    @JsonProperty("RE3F_CMCD")
    @Schema(description = "보조3필드공통코드")
    private String RE3F_CMCD;

    @JsonProperty("RE3F_CMNM")
    @Schema(description = "보조3필드공통코드명")
    private String RE3F_CMNM;

    @JsonProperty("RE3O_CODE")
    @Schema(description = "보조3필드출력형태코드")
    private String RE3O_CODE;

    @JsonProperty("RE4F_DESC")
    @Schema(description = "보조4필드설명")
    private String RE4F_DESC;

    @JsonProperty("RE4T_CODE")
    @Schema(description = "보조4필드입력형태코드")
    private String RE4T_CODE;

    @JsonProperty("RE4F_CMCD")
    @Schema(description = "보조4필드공통코드")
    private String RE4F_CMCD;

    @JsonProperty("RE4F_CMNM")
    @Schema(description = "보조4필드공통코드명")
    private String RE4F_CMNM;

    @JsonProperty("RE4O_CODE")
    @Schema(description = "보조4필드출력형태코드")
    private String RE4O_CODE;

    @JsonProperty("RE5F_DESC")
    @Schema(description = "보조5필드설명")
    private String RE5F_DESC;

    @JsonProperty("RE5T_CODE")
    @Schema(description = "보조5필드입력형태코드")
    private String RE5T_CODE;

    @JsonProperty("RE5F_CMCD")
    @Schema(description = "보조5필드공통코드")
    private String RE5F_CMCD;

    @JsonProperty("RE5F_CMNM")
    @Schema(description = "보조5필드공통코드명")
    private String RE5F_CMNM;

    @JsonProperty("RE5O_CODE")
    @Schema(description = "보조4필드출력형태코드")
    private String RE5O_CODE;

    @JsonProperty("RE6F_DESC")
    @Schema(description = "보조6필드설명")
    private String RE6F_DESC;

    @JsonProperty("RE6T_CODE")
    @Schema(description = "보조6필드입력형태코드")
    private String RE6T_CODE;

    @JsonProperty("RE6F_CMCD")
    @Schema(description = "보조6필드공통코드")
    private String RE6F_CMCD;

    @JsonProperty("RE6F_CMNM")
    @Schema(description = "보조6필드공통코드명")
    private String RE6F_CMNM;

    @JsonProperty("RE6O_CODE")
    @Schema(description = "보조4필드출력형태코드")
    private String RE6O_CODE;

    @JsonProperty("RE7F_DESC")
    @Schema(description = "보조7필드설명")
    private String RE7F_DESC;

    @JsonProperty("RE7T_CODE")
    @Schema(description = "보조7필드입력형태코드")
    private String RE7T_CODE;

    @JsonProperty("RE7F_CMCD")
    @Schema(description = "보조7필드공통코드")
    private String RE7F_CMCD;

    @JsonProperty("RE7F_CMNM")
    @Schema(description = "보조7필드공통코드명")
    private String RE7F_CMNM;

    @JsonProperty("RE7O_CODE")
    @Schema(description = "보조4필드출력형태코드")
    private String RE7O_CODE;

    @JsonProperty("RE8F_DESC")
    @Schema(description = "보조8필드설명")
    private String RE8F_DESC;

    @JsonProperty("RE8T_CODE")
    @Schema(description = "보조8필드입력형태코드")
    private String RE8T_CODE;

    @JsonProperty("RE8F_CMCD")
    @Schema(description = "보조8필드공통코드")
    private String RE8F_CMCD;

    @JsonProperty("RE8F_CMNM")
    @Schema(description = "보조8필드공통코드명")
    private String RE8F_CMNM;

    @JsonProperty("RE8O_CODE")
    @Schema(description = "보조4필드출력형태코드")
    private String RE8O_CODE;

    @JsonProperty("RE9F_DESC")
    @Schema(description = "보조9필드설명")
    private String RE9F_DESC;

    @JsonProperty("RE9T_CODE")
    @Schema(description = "보조9필드입력형태코드")
    private String RE9T_CODE;

    @JsonProperty("RE9F_CMCD")
    @Schema(description = "보조9필드공통코드")
    private String RE9F_CMCD;

    @JsonProperty("RE9F_CMNM")
    @Schema(description = "보조9필드공통코드명")
    private String RE9F_CMNM;

    @JsonProperty("RE9O_CODE")
    @Schema(description = "보조4필드출력형태코드")
    private String RE9O_CODE;

    @JsonProperty("R10F_DESC")
    @Schema(description = "보조10필드설명")
    private String R10F_DESC;

    @JsonProperty("R10T_CODE")
    @Schema(description = "보조10필드입력형태코드")
    private String R10T_CODE;

    @JsonProperty("R10F_CMCD")
    @Schema(description = "보조10필드공통코드")
    private String R10F_CMCD;

    @JsonProperty("R10F_CMNM")
    @Schema(description = "보조10필드공통코드명")
    private String R10F_CMNM;

    @JsonProperty("R10O_CODE")
    @Schema(description = "보조10필드출력형태코드")
    private String R10O_CODE;

    @JsonProperty("REMK_100X")
    @Schema(description = "비고100")
    private String REMK_100X;

    @JsonProperty("ISET_YSNO")
    @Schema(description = "초기세팅여부")
    private String ISET_YSNO;
}
