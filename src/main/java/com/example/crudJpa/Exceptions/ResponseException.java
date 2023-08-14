package com.example.crudJpa.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseException {
    public int code;
    public String message;
    public String timeStamp;
}
