package com.neosoft.demopoc.service;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
@Data
public class PropertyReader {

    @Value("${secretKeyYml}")
    private String secretKey;

    @Value("${HASHING_ALGORITHM}")
    private String HASHING_ALGORITHM;

    @Value("${clientId}")
    private String clientID;

}
