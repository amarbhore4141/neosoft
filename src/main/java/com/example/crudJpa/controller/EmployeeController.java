package com.example.crudJpa.controller;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.dto.EmployeeDto;
import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("API/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/emp")
    public String registerEmployee(@RequestBody EmployeeDto employee)
        {
            employeeService.registerEmployee(employee);
            return "Employee Registered";
        }

    @DeleteMapping ("/emp/{empId}")
    public String deleteEmployee(@RequestParam int empId)
    {
        employeeService.deleteEmployee(empId);
        return "Employee Registered";
    }




}
