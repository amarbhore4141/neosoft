package com.example.crudJpa.controller;


import com.example.crudJpa.dto.AppResponse;
import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v2/departments")
public class DepartmentController {
    @Autowired
    DeptService deptService;

    @PostMapping("")
    public ResponseEntity<AppResponse> addDepartment(@RequestBody @Valid DepartmentDto dept) {
        System.out.println("Inside dept controller: " + dept);

        return deptService.addDept(dept);
    }

    @GetMapping("")
    public ResponseEntity<AppResponse> getAllDepartments() {
        return deptService.getAll();
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<AppResponse> deleteDepartment(@PathVariable int deptId) {
        return deptService.deleteById(deptId);
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<AppResponse> updateDepartment(@PathVariable int deptId, @RequestParam String deptName) {
        ResponseEntity<AppResponse> dtoResponseEntity = null;

        return deptService.updateDept(deptId, deptName);
    }
}
