package com.example.crudJpa.service.serviceImpl;

import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.entity.DepartmentEntity;
import com.example.crudJpa.entity.SkillsEntity;
import com.example.crudJpa.repo.DepartmentRepository;
import com.example.crudJpa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptSerrviceImpl implements DeptService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<String> addDept(DepartmentDto dept) {
        String msg="";
        System.out.println(dept);
        DepartmentEntity de=new DepartmentEntity();
        DepartmentEntity existingDept=departmentRepository.findByDeptName(dept.getDeptName());

        if(existingDept != null){
            msg="Department already present";

        }else {
            DepartmentEntity departmentEntity=new DepartmentEntity();
            departmentEntity.setDeptName(dept.getDeptName().toUpperCase());
            departmentRepository.save(departmentEntity);
            msg="dept added successfully!";}

        return ResponseEntity.ok(msg);
    }

    @Override
    public  List<DepartmentEntity>  getAll() {

        List<DepartmentEntity> departmentEntityList =departmentRepository.findAll();
        return departmentEntityList;
    }

    @Override
    public void deleteById(int deptId) {
        if(departmentRepository.findById(deptId) != null){
            departmentRepository.deleteById(deptId);
        }else{
            System.out.println("return response entity with message id not exist");
        }

    }

    @Override
    public void updateDept(int deptId, String deptName) {
    DepartmentEntity departmentEntity= departmentRepository.findById(deptId).get();
    if(departmentEntity != null){
        departmentEntity.setDeptName(deptName);
        departmentRepository.save(departmentEntity);
    }
    else{
        System.out.println("return response entity with message id not exist");
    }
    }
}
