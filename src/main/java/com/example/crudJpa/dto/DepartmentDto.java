package com.example.crudJpa.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class DepartmentDto {
    private String deptName;
}
