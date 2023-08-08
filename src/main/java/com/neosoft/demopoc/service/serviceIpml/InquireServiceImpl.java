package com.neosoft.demopoc.service.serviceIpml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.demopoc.dto.CasInquiryRequest;
import com.neosoft.demopoc.dto.DataExternalApiResponse;
import com.neosoft.demopoc.dto.ExternalApiRequest;
import com.neosoft.demopoc.exception.RecordCantBeRetrievedException;
import com.neosoft.demopoc.service.InquireService;
import com.neosoft.demopoc.service.PropertyReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
@Service
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class InquireServiceImpl implements InquireService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PropertyReader propertyReader;

    @Override
    public ResponseEntity<DataExternalApiResponse> enquiryRequest(CasInquiryRequest casInquiryRequest) throws JsonProcessingException {
        String jsonPayload = null;
        //throw custom exception
        System.out.println("cas enquiry request dat in service layer"+casInquiryRequest);
        if((casInquiryRequest.getCustomerId()==null || casInquiryRequest.getCustomerType()==null ) && (casInquiryRequest.getInstrumentList() ==null || casInquiryRequest.getInstrumentType()==null))
            {

                    throw new RecordCantBeRetrievedException("Please enter both required fields");
            }

        String apiUrl="https://cas.test-benefitpay.bh/benefit-cas/ext/v1/cas/iban-directories/inquire";

        ExternalApiRequest eapi=new ExternalApiRequest();
        if(casInquiryRequest.getCustomerId() != null){eapi.setCustomer_id(casInquiryRequest.getCustomerId());}
        if(casInquiryRequest.getCustomerIdType() != null){eapi.setCustomer_id_type(casInquiryRequest.getCustomerIdType());}
        if(casInquiryRequest.getCustomerType() != null) {eapi.setCustomer_type(casInquiryRequest.getCustomerType());}
        eapi.setInstruments_ids(casInquiryRequest.getInstrumentList());
        eapi.setInstrument_type(casInquiryRequest.getInstrumentType());
        eapi.setMobile_no(casInquiryRequest.getMobileNo());
        eapi.setReference_id(casInquiryRequest.getReference_id());
        eapi.setPage_size(9);
        eapi.setPage_no(1);

        ObjectMapper objectMapper = new ObjectMapper();

            jsonPayload = objectMapper.writeValueAsString(eapi);

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("x-foo-signature", getSignatureKey(jsonPayload));
        httpHeaders.set("x-client-id", propertyReader.getClientID());
        httpHeaders.set("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayload,httpHeaders);

        log.info("property reader values: "+propertyReader.toString());
        log.info("Request Entity values passed :"+requestEntity.toString());
        log.info("Json Payload data"+jsonPayload);
        log.info("Request Entity:"+requestEntity);
        ResponseEntity<DataExternalApiResponse> dataExternalApiResponse = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, DataExternalApiResponse.class);
        String mr = String.valueOf(restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity,String.class));
        log.info("String RESPONSE"+mr);
        DataExternalApiResponse dataExternalApiResponseBody=dataExternalApiResponse.getBody();

        System.out.println(dataExternalApiResponse);
        return ResponseEntity.ok(dataExternalApiResponseBody);
    }

    public String getSignatureKey(String jsonPayload){
        String signature = null;
        String HASHING_ALGORITHM=propertyReader.getHASHING_ALGORITHM();
        try {
            SecretKeySpec keySpec = new SecretKeySpec(propertyReader.getSecretKey().getBytes(StandardCharsets.UTF_8), HASHING_ALGORITHM);
            Mac hmacSha256 = Mac.getInstance(HASHING_ALGORITHM);
            hmacSha256.init(keySpec);
            byte[] hashBytes = hmacSha256.doFinal(jsonPayload.getBytes(StandardCharsets.UTF_8));
            signature = Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return signature;
    }

}


