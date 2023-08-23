package com.neosoft.CriteriaQueryUsingHibernateTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String empName;
    private String salary;
    private String city;
}
