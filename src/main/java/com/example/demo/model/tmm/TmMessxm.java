package com.example.demo.model.tmm;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "메시지")
@Getter
@Setter
@ToString
@Component
@SuppressWarnings("java:S116")
public class TmMessxm {
    private String id;
    
    @JsonProperty("MSGE_CODE")
    @Schema(description = "메시지코드")
    private String MSGE_CODE;
    
    @JsonProperty("MSGE_CNTT")
    @Schema(description = "메시지내용")
    private String MSGE_CNTT;
    
    @JsonProperty("MSEN_CNTT")
    @Schema(description = "메시지영문내용")
    private String MSEN_CNTT;
    
    @JsonProperty("MSKN_CODE")
    @Schema(description = "메시지종류")
    private String MSKN_CODE;
    
    @JsonProperty("MSDV_CODE")
    @Schema(description = "메시지구분")
    private String MSDV_CODE;
}
