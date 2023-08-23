package com.neosoft.CriteriaQueryUsingHibernateTemplate.controller;

import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.AppResponse;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.Employee;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("")
    public ResponseEntity<AppResponse> registerEliteEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.registerEliteEmployee(employee);
    }

    @GetMapping("")
    public ResponseEntity<AppResponse> showEmployees() {
        return employeeServiceImpl.showAll();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<AppResponse> getById(@PathVariable int empId) {
        return employeeServiceImpl.getById(empId);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<AppResponse> deleteById(@PathVariable int empId) {
        return employeeServiceImpl.deleteById(empId);
    }


    @PutMapping ("")
    public ResponseEntity<AppResponse> updateEmployee(@RequestBody Employee employee,@RequestParam int empId) {
        return employeeServiceImpl.updateEmployee(empId,employee);
    }

}
