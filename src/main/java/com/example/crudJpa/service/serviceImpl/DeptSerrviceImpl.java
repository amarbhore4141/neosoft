package com.example.crudJpa.service.serviceImpl;

import com.example.crudJpa.Exceptions.DepartmentNotFoundExcetion;
import com.example.crudJpa.dto.AppResponse;
import com.example.crudJpa.dto.DepartmentDto;
import com.example.crudJpa.entity.DepartmentEntity;
import com.example.crudJpa.repo.DepartmentRepository;
import com.example.crudJpa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptSerrviceImpl implements DeptService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<AppResponse> addDept(DepartmentDto dept) {
        String msg = "";
        System.out.println(dept);
        DepartmentEntity de = new DepartmentEntity();
        DepartmentEntity existingDept = departmentRepository.findByDeptName(dept.getDeptName());
        AppResponse departmentResponseDto = new AppResponse();
        if (existingDept != null) {
            msg = "Department already present";
            departmentResponseDto.setMessage(msg);
            departmentResponseDto.setCode(400);
            departmentResponseDto.setData(existingDept);

        } else {
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setDeptName(dept.getDeptName().toUpperCase());
            departmentRepository.save(departmentEntity);
            msg = "dept added successfully!";
            departmentResponseDto.setMessage(msg);
            departmentResponseDto.setCode(200);
            departmentResponseDto.setData(departmentEntity);
        }

        return ResponseEntity.status(HttpStatus.valueOf(departmentResponseDto.getCode())).body(departmentResponseDto);
    }

    @Override
    public ResponseEntity<AppResponse> getAll() {

        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        AppResponse departmentResponseDto = new AppResponse();
        if (departmentEntityList.isEmpty()) {
            departmentResponseDto.setMessage("No Records Found");
            departmentResponseDto.setCode(HttpStatus.NOT_FOUND.value());
            departmentResponseDto.setData(departmentEntityList);
        } else {
            departmentResponseDto.setMessage("Following Records Found");
            departmentResponseDto.setCode(HttpStatus.OK.value());
            departmentResponseDto.setData(departmentEntityList);
        }
        // return departmentEntityList;
        return ResponseEntity.status(HttpStatus.valueOf(departmentResponseDto.getCode())).body(departmentResponseDto);
    }

    @Override
    public ResponseEntity<AppResponse> deleteById(int deptId) {
        AppResponse departmentResponseDto = new AppResponse();
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(deptId);

        if (departmentEntity.isPresent()) {
            departmentResponseDto.setData(departmentEntity.get());
            departmentRepository.deleteById(deptId);
            departmentResponseDto.setCode(HttpStatus.OK.value());
            departmentResponseDto.setMessage("Department Deleted successfully:");
            return ResponseEntity.status(HttpStatus.valueOf(departmentResponseDto.getCode())).body(departmentResponseDto);
        }
        throw new DepartmentNotFoundExcetion("Department you want to Delete with id : " + deptId + " does't Exists in Database.");

    }

    @Override
    public ResponseEntity<AppResponse> updateDept(int deptId, String deptName) throws DepartmentNotFoundExcetion {

        AppResponse departmentResponseDto = new AppResponse<>();
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(deptId);


        if (departmentEntity.isPresent()) {
            DepartmentEntity de = departmentEntity.get();
            departmentEntity.get().setDeptName(deptName);
            departmentRepository.save(de);
            departmentResponseDto.setCode(HttpStatus.OK.value());
            departmentResponseDto.setMessage("Department updated successfully");

            return ResponseEntity.status(HttpStatus.valueOf(departmentResponseDto.getCode())).body(departmentResponseDto);

        } else {

            throw new DepartmentNotFoundExcetion("Department wit id :" + deptId + " Not Found in database, So unable to update the Department");

        }


    }

}
