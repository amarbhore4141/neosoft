package com.example.crudJpa.dto;

import com.example.crudJpa.entity.DepartmentEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AppResponse<T> {
    private int code;
    private String message;
    private T data;

}
