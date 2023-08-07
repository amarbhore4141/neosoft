package com.neosoft.demopoc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neosoft.demopoc.dto.CasInquiryRequest;
import com.neosoft.demopoc.dto.DataExternalApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface InquireService {


   public ResponseEntity<DataExternalApiResponse> enquiryRequest(CasInquiryRequest casInquiryRequest) throws JsonProcessingException;
}
