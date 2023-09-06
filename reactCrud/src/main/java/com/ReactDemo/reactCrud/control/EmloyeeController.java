package com.ReactDemo.reactCrud.control;

import com.ReactDemo.reactCrud.model.Employee;
import com.ReactDemo.reactCrud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmloyeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
}
