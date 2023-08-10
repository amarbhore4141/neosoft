package com.example.crudJpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {
    private String addressline1;
    private String city;
    private String state;
    private long pincode;
}
