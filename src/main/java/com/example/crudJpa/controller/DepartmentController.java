package com.example.crudJpa.controller;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.entity.DepartmentEntity;
import com.example.crudJpa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v2/departments")
public class DepartmentController {
    @Autowired
    DeptService deptService;

    @PostMapping("")
    public ResponseEntity<String> addDepartment(@RequestBody @Valid DepartmentDto dept)
    {
        System.out.println("Inside dept controller: "+dept);
        return deptService.addDept(dept);
    }
    @GetMapping("")
    public List<DepartmentEntity>  getAllDepartments()
    {
        List<DepartmentEntity> departmentEntityList=deptService.getAll();
        return departmentEntityList;
    }

    @DeleteMapping("/{deptId}")
    public void deleteDepartment(@PathVariable int deptId)
    {
        deptService.deleteById(deptId);
    }

    @PutMapping("/{deptId}")
    public void updateDepartment(@PathVariable int deptId,@RequestParam String deptName){
        deptService.updateDept(deptId,deptName);
    }
}
