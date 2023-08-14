package com.example.crudJpa.controller;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.dto.EmployeeDto;
import com.example.crudJpa.dto.SkillsDto;
import com.example.crudJpa.entity.EmployeeEntity;
import com.example.crudJpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    public String registerEmployee(@RequestBody @Valid EmployeeDto employee) {
        employeeService.registerEmployee(employee);
        return "Employee Registered";
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployee(empId);
        return "Employee Registered";
    }

    @GetMapping("")
    public List<EmployeeEntity> showAllEmployee() {
        List<EmployeeEntity> employeeEntityList = employeeService.showAll();
        return employeeEntityList;
    }

    @PutMapping("/{empId}")
    public void updateEmployee(@PathVariable int empId, @RequestBody EmployeeDto employeeDto) {

        employeeService.updateEmployeeData(employeeDto, empId);
    }

}
