package com.example.crudJpa.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SkillsEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int skillID;
      private String skillName;
      @ManyToMany(mappedBy = "empSkills")
      private List<EmployeeEntity> employeeEntity;
}
