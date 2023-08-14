package com.example.crudJpa.service;

import com.example.crudJpa.Exceptions.DepartmentNotFoundExcetion;
import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.dto.AppResponse;
import com.example.crudJpa.entity.DepartmentEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    ResponseEntity<AppResponse> addDept(DepartmentDto dept);

    ResponseEntity<AppResponse> getAll();

    ResponseEntity<AppResponse> deleteById(int deptId);

    ResponseEntity<AppResponse> updateDept(int deptId, String deptName) throws DepartmentNotFoundExcetion;
}
