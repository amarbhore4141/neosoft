package com.neosoft.jpqlpoc.service;

import com.neosoft.jpqlpoc.Entity.Address;
import com.neosoft.jpqlpoc.Entity.Employee;
import com.neosoft.jpqlpoc.Response.AppResponse;
import com.neosoft.jpqlpoc.repo.AddressRepo;
import com.neosoft.jpqlpoc.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeJpaService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressRepo addressRepo;


    public ResponseEntity<AppResponse> register(Employee employee) {
        try{employee.getAddresses().stream().forEach(n->n.setEmployee(employee));}catch (Exception e){
            System.out.println(e);
        }

        Employee returnedEmployee=employeeRepo.save(employee);


        AppResponse appResponse=new AppResponse<>();
        appResponse.setData(returnedEmployee);
        appResponse.setMessage("Employee registered successfully");
        appResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(appResponse);
    }

    public ResponseEntity<AppResponse> findUserByAddressId(int addressId) {
        Employee employee=employeeRepo.findByAddresses_AddressId(addressId);
        System.out.println("EmployeeData"+employee);
        AppResponse appResponse=new AppResponse<>();
        appResponse.setData(employee);
        return ResponseEntity.ok(appResponse);
    }

    public ResponseEntity<AppResponse> findUsersByCity(String city) {
        List<Employee> employeeList=employeeRepo.findByAddresses_City(city);
        AppResponse appResponse=new AppResponse<>();
        appResponse.setData(employeeList);
        return ResponseEntity.ok(appResponse);
    }
}
