package com.microapiempmanage.Project_service.impl;


import com.microapiempmanage.Project_service.entities.Department;
import com.microapiempmanage.Project_service.repository.DepartmentRepository;
import com.microapiempmanage.Project_service.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class Departmentimpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepts(){
        List<Department> dlist = departmentRepository.findAll();
        return dlist;
    }

    @Override
    public Department getDept(Integer deptId) {
        Department d1 = departmentRepository.findById(deptId).get();
        return d1;


    }

    @Override
    public Department addDept(Department department) {
        UUID uid = UUID.randomUUID();
        department.setDuuid(uid);
        return departmentRepository.save(department);

    }

    @Override
    public Department updateDept(Integer deptId, Department newDepartment) {
        Department olddept = departmentRepository.findById(deptId).get();
        olddept.setDeptName(newDepartment.getDeptName());
        return departmentRepository.save(olddept);
    }

    @Override
    public ResponseEntity<String> deleteDept(Integer deptId) {
        Optional<Department> optionalDepartment = Optional.ofNullable(departmentRepository.findById(deptId).get());

        if (optionalDepartment.isPresent()) {
            Department departmentToDelete = optionalDepartment.get();
            // Delete the department
            departmentRepository.delete(departmentToDelete);
            return ResponseEntity.ok("Department deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
