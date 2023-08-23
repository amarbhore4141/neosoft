package com.neosoft.CriteriaQueryUsingHibernateTemplate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse<T> {
    private int code;
    private String message;
    private T data;

}