package com.neosoft.demopoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataExternalApiResponse {

    private Object[] additional_data;
    private String status;
    private String message;
    private Result customer_instruments;
    private String code;
    private String code_type;


}
