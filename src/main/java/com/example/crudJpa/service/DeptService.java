package com.example.crudJpa.service;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.entity.DepartmentEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    ResponseEntity<String> addDept(DepartmentDto dept);

    List<DepartmentEntity> getAll();

    void deleteById(int deptId);

    void updateDept(int deptId, String deptName);
}
