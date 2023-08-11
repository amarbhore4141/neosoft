package com.example.crudJpa.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @NotNull
    private String empName;
    private List<AddressDto> addressList;
    private DepartmentDto departmentDto;
    private List<SkillsDto> skillsDtos;

}
