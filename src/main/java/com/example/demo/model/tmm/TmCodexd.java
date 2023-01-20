package com.example.demo.model.tmm;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "세부코드")
@Getter
@Setter
@ToString
@Component
@SuppressWarnings("java:S116")
public class TmCodexd {
    private String id;

    @JsonProperty("COMM_CODE")
    @Schema(description = "공통코드")
    private String COMM_CODE;

    @JsonProperty("COMD_CODE")
    @Schema(description = "세부코드")
    private String COMD_CODE;

    @JsonProperty("COMD_CDNM")
    @Schema(description = "세부코드명")
    private String COMD_CDNM;

    @JsonProperty("COMD_ENNM")
    @Schema(description = "세부영문명")
    private String COMD_ENNM;

    @JsonProperty("CRTE_DATE")
    @Schema(description = "생성일")
    private String CRTE_DATE;

    @JsonProperty("WAST_DATE")
    @Schema(description = "폐기일")
    private String WAST_DATE;

    @JsonProperty("REF1_FILD")
    @Schema(description = "보조1필드")
    private String REF1_FILD;

    @JsonProperty("REF2_FILD")
    @Schema(description = "보조2필드")
    private String REF2_FILD;

    @JsonProperty("REF3_FILD")
    @Schema(description = "보조3필드")
    private String REF3_FILD;

    @JsonProperty("REF4_FILD")
    @Schema(description = "보조4필드")
    private String REF4_FILD;

    @JsonProperty("REF5_FILD")
    @Schema(description = "보조5필드")
    private String REF5_FILD;

    @JsonProperty("REF6_FILD")
    @Schema(description = "보조6필드")
    private String REF6_FILD;

    @JsonProperty("REF7_FILD")
    @Schema(description = "보조7필드")
    private String REF7_FILD;

    @JsonProperty("REF8_FILD")
    @Schema(description = "보조8필드")
    private String REF8_FILD;

    @JsonProperty("REF9_FILD")
    @Schema(description = "보조9필드")
    private String REF9_FILD;

    @JsonProperty("RE10_FILD")
    @Schema(description = "보조10필드")
    private String RE10_FILD;

    @JsonProperty("OERP_CODE")
    @Schema(description = "구ERP코드")
    private String OERP_CODE;

    @JsonProperty("REMK_100X")
    @Schema(description = "비고100")
    private String REMK_100X;

    @JsonProperty("SORT_ORDR")
    @Schema(description = "정렬순서")
    private String SORT_ORDR;
}
