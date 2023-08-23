package com.neosoft.CriteriaQueryUsingHibernateTemplate.serviceImpl;

import com.neosoft.CriteriaQueryUsingHibernateTemplate.dao.EmployeeDaoImpl;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.AppResponse;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.Employee;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.entity.EmployeeEntity;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;
    @Override
    public ResponseEntity<AppResponse> registerEliteEmployee(Employee employee) {
        EmployeeEntity employeeEntity=EmployeeEntity.builder().empName(employee.getEmpName()).city(employee.getCity()).salary(employee.getSalary()).build();
        return employeeDaoImpl.registerEliteEmployee(employeeEntity);
    }

    @Override
    public ResponseEntity<AppResponse> showAll() {
        return employeeDaoImpl.showAll();
    }

    @Override
    public ResponseEntity<AppResponse> getById(int empId) {
        return employeeDaoImpl.getById(empId);
    }

    @Override
    public ResponseEntity<AppResponse> deleteById(int empId) {
        return employeeDaoImpl.deleteById(empId);
    }

    @Override
    public ResponseEntity<AppResponse> updateEmployee(int empId, Employee employee) {

        return employeeDaoImpl.updateEmployee(empId,employee);
    }
}
