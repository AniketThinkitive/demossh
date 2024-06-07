package com.microapiempmanage.Project_service.services;


import com.microapiempmanage.Project_service.entities.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DepartmentService {

    List<Department> getDepts();
    Department getDept(Integer deptId);
    Department addDept(Department department);
    Department updateDept(Integer deptId,Department department);
    ResponseEntity<String> deleteDept(Integer deptId);


}
