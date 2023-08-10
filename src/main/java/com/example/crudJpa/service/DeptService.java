package com.example.crudJpa.service;

import com.example.crudJpa.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface DeptService {
    ResponseEntity<String> addDept(DepartmentDto dept);
}
