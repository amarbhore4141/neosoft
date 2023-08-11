package com.example.crudJpa.service;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.dto.EmployeeDto;
import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    void registerEmployee(EmployeeDto employee);


    void deleteEmployee(int empId);

    List<EmployeeEntity> showAll();

    void updateEmployeeData(EmployeeDto employeeDto, int empId);
}
