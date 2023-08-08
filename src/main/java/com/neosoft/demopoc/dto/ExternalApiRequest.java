package com.neosoft.demopoc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalApiRequest {
        private String customer_id;
        private String customer_id_type;
        private String customer_type;
        private String mobile_no;
        private List<Instrument> instruments_ids;
        private String instrument_type;
        private String alias;
        private String corporate_alias;
        @JsonIgnore
        private boolean sijili;
        private int page_no;
        private int page_size;
        private String reference_id;
}
