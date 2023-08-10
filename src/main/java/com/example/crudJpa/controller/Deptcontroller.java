package com.example.crudJpa.controller;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.service.DeptService;
import com.example.crudJpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Deptcontroller {
    @Autowired
    DeptService deptService;

    @PostMapping("/addDepartment")
    public ResponseEntity<String> addDept(@RequestBody DepartmentDto dept)
    {
        System.out.println("Inside dept controller: "+dept);
        return deptService.addDept(dept);
    }
}
