package com.neosoft.jpqlpoc.controller;

import com.neosoft.jpqlpoc.Entity.Employee;
import com.neosoft.jpqlpoc.Response.AppResponse;
import com.neosoft.jpqlpoc.service.EmployeeJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeController {
    @Autowired
    private EmployeeJpaService employeeJpaService;
    @PostMapping("/register")
    public ResponseEntity<AppResponse> registerAddress(@RequestBody Employee employee){
    return employeeJpaService.register(employee);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<AppResponse> findUserByAddressId(@RequestParam int addressId){
        return employeeJpaService.findUserByAddressId(addressId);
    }

    @GetMapping("/getUsersByCity")
    public ResponseEntity<AppResponse> findUserListByCity(@RequestParam String city){
        return employeeJpaService.findUsersByCity(city);
    }
}
