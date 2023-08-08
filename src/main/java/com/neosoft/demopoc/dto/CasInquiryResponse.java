package com.neosoft.demopoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CasInquiryResponse {

    private DataExternalApiResponse ibanDirResponse;
}
