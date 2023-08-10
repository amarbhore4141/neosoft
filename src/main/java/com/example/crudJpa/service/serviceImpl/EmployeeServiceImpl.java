package com.example.crudJpa.service.serviceImpl;

import com.example.crudJpa.dto.*;
import com.example.crudJpa.entity.AddressEntity;
import com.example.crudJpa.entity.DepartmentEntity;
import com.example.crudJpa.entity.EmployeeEntity;
import com.example.crudJpa.entity.SkillsEntity;
import com.example.crudJpa.repo.AddressRepository;
import com.example.crudJpa.repo.DepartmentRepository;
import com.example.crudJpa.repo.EmployeeRepository;
import com.example.crudJpa.repo.SkillsRepository;
import com.example.crudJpa.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public void registerEmployee(EmployeeDto employee) {
        String msg="";
        System.out.println("inside register employee service");
        System.out.println(employee);

        // creating new empEntity
      EmployeeEntity emp=new EmployeeEntity();

      //setting empname
      emp.setEmpName(employee.getEmpName());

      //finding if dept exist
        DepartmentEntity dte=departmentRepository.findByDeptName(employee.getDepartmentDto().getDeptName());
        //if exist ,then assign to employee
        if(dte == null){
             msg="Department Does't Exist";
             log.debug("Department Does't Exist");
             System.out.println("Department Does't Exist");
        }else {

            emp.setEmpDept(dte);
            log.info("Dept assigned to employee");
            msg="Dept assigned to employee";

            //finding if skills are in skillRepository, if exist then add
            List<SkillsDto> skillsPassed=employee.getSkillsDtos();
            System.out.println(skillsPassed);

            List<SkillsEntity> skillsToAdd=new ArrayList<>();

            for(SkillsDto sdt:skillsPassed){
                SkillsEntity skillsEntity=skillsRepository.findBySkillName(sdt.getSkillName());
                if(skillsEntity == null){
                    msg="skills you are trying to add are not present in database";
                } else{
                    skillsToAdd.add(skillsEntity);
                    System.out.println("Skill present: added successfully");
                }

            }
            emp.setEmpSkills(skillsToAdd);

            //add addresses given
          List<AddressDto> providedAddressList = employee.getAddressList();
          List<AddressEntity> addressEntityToAdd =new ArrayList<>();
          for(AddressDto adrs:providedAddressList)
          {
              AddressEntity address=new AddressEntity();
              address.setAddressline1(adrs.getAddressline1());
              address.setCity(adrs.getCity());
              address.setState(adrs.getState());
              address.setPincode(adrs.getPincode());
              address.setEmployee(emp);
              System.out.println(address);
              addressEntityToAdd.add(address);

          }
            emp.setEmpAddressEntities(addressEntityToAdd);
            employeeRepository.save(emp);

        }


    }

    @Override
    public void deleteEmployee(int empId) {
        employeeRepository.deleteById(empId);
    }


}
