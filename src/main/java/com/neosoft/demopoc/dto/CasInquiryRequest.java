package com.neosoft.demopoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.Transient;
import java.util.List;
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CasInquiryRequest {
    @Size(max = 40,message = " Customer Id Should not be greater than 40")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String customerId;
    @Size(max = 50,message = "Customer Id Type Should not be greater than 50")
    private String customerIdType;
    @Size(max = 50,message = "customer Type Should not be greater than 50")
    private String customerType;
    @Size(max = 20, message = "Mobile number Should not be greater than 20")
    private String mobileNo;
    @Size(max = 29,message = "Instrument list Should not be greater than 29")
    private List<Instrument> instrumentList;
    @Size(max = 50,message = "Instrument type Should not be greater than 50 ")
    private String instrumentType;
    @Size(max = 75, message = "alias Should not be greater than 75")
    private String alias;
    @Size(max = 10)
    private String corporateAlias;
    private Sijili sijili;

    private int pageNo;
    private int pageSize;
    private String reference_id;


}
