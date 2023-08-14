package com.example.crudJpa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<AddressEntity> empAddressEntities = new ArrayList<>();


    @OneToOne(cascade = CascadeType.DETACH)
    private DepartmentEntity empDept;

    @ManyToMany(cascade = CascadeType.DETACH)
    private List<SkillsEntity> empSkills = new ArrayList<>();
}
