package com.neosoft.jpqlpoc.repo;

import com.neosoft.jpqlpoc.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
    Employee findByAddresses_AddressId(int addressId);

    List<Employee> findByAddresses_City(String city);
}
