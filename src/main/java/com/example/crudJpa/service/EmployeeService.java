package com.example.crudJpa.service;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.dto.EmployeeDto;
import com.example.crudJpa.dto.SkillsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface EmployeeService {
    void registerEmployee(EmployeeDto employee);


    void deleteEmployee(int empId);
}
