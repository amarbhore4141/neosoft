package com.neosoft.poc.staticDynamicJsonFiltering.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppResponse <T>{
    private String message;
    private int code;
    private T data;
}
