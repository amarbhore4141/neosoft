package com.neosoft.demopoc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class InstrumentDto {
    private String mobile_no;
    private String instrument_id;
    private String instrument_type;
    private String status;
    private String bank_account_type;
    private String bank_id;
    private String email;
    private boolean user_consent;
    //two fields with UNIX timestamp
    private long registeration_date;
    private long last_update_date;
    private String name;
    private String address_1;
    private String address_2;
    private String address_3;
    private String country;
    private String city;
    private String building;
    private String flat;
    private String road;
    private String block;
    //personel type fields
    private String alias;
    private String nationality;
    private String gender;
    // birthdate : Unix timestamp
    private long birthdate;
    //here onwards business type fields
    private String business_name;
    private String mcc;
    private boolean sijili;
    private String corporate_alias;
    private String vat_id;

}
