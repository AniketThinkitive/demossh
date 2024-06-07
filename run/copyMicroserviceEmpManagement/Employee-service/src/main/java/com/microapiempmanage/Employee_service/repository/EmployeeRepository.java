package com.microapiempmanage.Employee_service.repository;


import com.microapiempmanage.Employee_service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    ScopedValue<Object> findById(UUID empId);
//
//    Employee findByEuuid(UUID empId);
//
//    Employee deleteByEuuid(UUID empId);
}
