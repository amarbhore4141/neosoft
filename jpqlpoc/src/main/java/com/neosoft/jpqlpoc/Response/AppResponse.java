package com.neosoft.jpqlpoc.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppResponse <T>{
    private String message;
    private int code;
    private T data;
}
