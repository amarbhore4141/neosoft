package com.example.crudJpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class SkillsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillID;
    private String skillName;
    @ManyToMany(mappedBy = "empSkills")
    @JsonIgnore
    private List<EmployeeEntity> employeeEntity;


}
