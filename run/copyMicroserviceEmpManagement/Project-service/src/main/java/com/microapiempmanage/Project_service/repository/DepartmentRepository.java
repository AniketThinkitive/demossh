package com.microapiempmanage.Project_service.repository;


import com.microapiempmanage.Project_service.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
//    Department findByDuuid(UUID deptId);
//
//    Department deleteByDuuid(UUID deptId);


}
