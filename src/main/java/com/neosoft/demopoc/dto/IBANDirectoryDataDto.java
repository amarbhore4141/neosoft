package com.neosoft.demopoc.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class IBANDirectoryDataDto {

    private String customer_id;

    private String customer_id_type;
    private String customer_type;

    // array of instrument
    private List<InstrumentDto> instruments;


}
