package com.neosoft.CriteriaQueryUsingHibernateTemplate.dao;

import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.AppResponse;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.Employee;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

public interface EmployeeDao {
    ResponseEntity<AppResponse> registerEliteEmployee(EmployeeEntity employeeEntity);
    ResponseEntity<AppResponse> showAll();

    ResponseEntity<AppResponse> getById(int empId);

    ResponseEntity<AppResponse> deleteById(int empId);


    ResponseEntity<AppResponse> updateEmployee(int empId, Employee employee);
}
