package com.neosoft.CriteriaQueryUsingHibernateTemplate.service;

import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.AppResponse;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.Employee;
import org.springframework.http.ResponseEntity;


public interface EmployeeService {
    ResponseEntity<AppResponse> registerEliteEmployee(Employee employee);

    ResponseEntity<AppResponse> showAll();

    ResponseEntity<AppResponse> getById(int empId);

    ResponseEntity<AppResponse> deleteById(int empId);

    ResponseEntity<AppResponse> updateEmployee(int empId, Employee employee);
}
