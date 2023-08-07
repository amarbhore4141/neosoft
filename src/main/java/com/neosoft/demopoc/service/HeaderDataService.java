package com.neosoft.demopoc.service;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "header-data")
public class HeaderDataService {

    //TODO: read from prop file using annotation
    private  String contentType ;
    private  String xFooSignature;
    private  String clientId;


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getxFooSignature() {
        return xFooSignature;
    }

    public void setxFooSignature(String xFooSignature) {
        this.xFooSignature = xFooSignature;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "HeaderData{" +
                "contentType='" + contentType + '\'' +
                ", xFooSignature='" + xFooSignature + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
