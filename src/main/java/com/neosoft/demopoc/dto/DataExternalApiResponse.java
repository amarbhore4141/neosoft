package com.neosoft.demopoc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataExternalApiResponse {

    private Object[] additional_data;
    private String message;
    private String status;
//    private List<IBANDirectoryDataDto> customer_instruments;
    private Result customer_instruments;
    private MetaData metadata;
    private String code;
    private String code_type;


}
