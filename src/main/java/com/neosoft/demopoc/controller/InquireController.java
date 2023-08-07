package com.neosoft.demopoc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neosoft.demopoc.dto.CasInquiryRequest;
import com.neosoft.demopoc.dto.CasInquiryResponse;
import com.neosoft.demopoc.dto.DataExternalApiResponse;
import com.neosoft.demopoc.service.InquireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/cas/integration")
//@Slf4j//TODO: add logger dependency--- Added
@Slf4j
public class InquireController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InquireController.class);
    @Autowired
    private InquireService inquireService;

    @PostMapping("/inquire")
    public ResponseEntity<CasInquiryResponse> getInquireData(@RequestBody @Valid CasInquiryRequest casInquiryRequest){
       //call to service layer
        log.info("inside inquire of controller");
        log.info(casInquiryRequest.toString());

        CasInquiryResponse casInquiryResponse=new CasInquiryResponse();

        try {
            casInquiryResponse.setIbanDirResponse(inquireService.enquiryRequest(casInquiryRequest).getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(casInquiryResponse);
    }
}
