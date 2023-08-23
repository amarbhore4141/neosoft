package com.neosoft.CriteriaQueryUsingHibernateTemplate.dao;

import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.AppResponse;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.dto.Employee;
import com.neosoft.CriteriaQueryUsingHibernateTemplate.entity.EmployeeEntity;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.Serializable;
import java.util.List;

@Repository
@EnableTransactionManagement
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public ResponseEntity<AppResponse> registerEliteEmployee(EmployeeEntity employeeEntity) {

        Serializable SavedemployeeEntity =  hibernateTemplate.save(employeeEntity);

        AppResponse appResponse = new AppResponse();
        appResponse.setCode(HttpStatus.CREATED.value());
        appResponse.setMessage("Employee saved successfully!");
        appResponse.setData(SavedemployeeEntity);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(appResponse);
    }

    public ResponseEntity<AppResponse> showAll() {

        List<EmployeeEntity> allEmployee  =hibernateTemplate.loadAll(EmployeeEntity.class);

        AppResponse appResponse = new AppResponse();
        appResponse.setCode(HttpStatus.OK.value());
        appResponse.setMessage("All Employee data Successfully fetched!");
        appResponse.setData(allEmployee);

        return ResponseEntity.status(appResponse.getCode()).body(appResponse);
    }

    @Override
    public ResponseEntity<AppResponse> getById(int empId) {
        EmployeeEntity returnedEmployee=hibernateTemplate.get(EmployeeEntity.class,empId);

        AppResponse appResponse = new AppResponse();

        if(returnedEmployee != null){
            appResponse.setCode(HttpStatus.FOUND.value());
            appResponse.setMessage("Employee found");
            appResponse.setData(returnedEmployee);
        }
        else{
            appResponse.setCode(HttpStatus.NOT_FOUND.value());
            appResponse.setMessage("Employee not found");
        }

        return ResponseEntity.status(appResponse.getCode()).body(appResponse);
    }

    @Override
    public ResponseEntity<AppResponse> deleteById(int empId) {
        EmployeeEntity returnedEmployee=hibernateTemplate.get(EmployeeEntity.class,empId);
        System.out.println(returnedEmployee);
        AppResponse appResponse = new AppResponse();

        if(returnedEmployee == null){
            appResponse.setCode(HttpStatus.BAD_REQUEST.value());
            appResponse.setMessage("Employee you want to delete is not found!");

        }else {
            Transaction transaction = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
            hibernateTemplate.delete(returnedEmployee);
            transaction.commit();
            appResponse.setCode(HttpStatus.OK.value());
            appResponse.setMessage("Employee with id : "+empId+" deleted Successfully!");

               }

        return ResponseEntity.status(HttpStatus.OK.value()).body(appResponse);
    }

    @Override
    public ResponseEntity<AppResponse> updateEmployee(int empId, Employee employee) {
       EmployeeEntity employeeEntity=hibernateTemplate.get(EmployeeEntity.class,empId);
        AppResponse appResponse = new AppResponse();
       if(employeeEntity == null){
           appResponse.setCode(HttpStatus.NOT_FOUND.value());
           appResponse.setMessage("User you want to update does not exist!");
       }
       else {
           employeeEntity.setCity(employee.getCity());
           employeeEntity.setSalary(employee.getSalary());
           employeeEntity.setEmpName(employee.getEmpName());
           System.out.println(employeeEntity);
           Transaction transaction = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();

           hibernateTemplate.saveOrUpdate(employeeEntity);
           transaction.commit();

           appResponse.setCode(HttpStatus.ACCEPTED.value());
           appResponse.setMessage("Updated successfully!");
           appResponse.setData(employeeEntity);
       }

        return ResponseEntity.status(appResponse.getCode()).body(appResponse);
    }



}
