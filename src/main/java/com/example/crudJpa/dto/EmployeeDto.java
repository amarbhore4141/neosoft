package com.example.crudJpa.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String empName;
    private List<AddressDto> addressList;
    private DepartmentDto departmentDto;
    private List<SkillsDto> skillsDtos;

}
