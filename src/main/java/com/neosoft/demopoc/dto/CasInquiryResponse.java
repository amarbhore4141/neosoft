package com.neosoft.demopoc.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CasInquiryResponse {

    private MetaData metaDataCasEnquiry;
    private DataExternalApiResponse ibanDirResponse;
}
