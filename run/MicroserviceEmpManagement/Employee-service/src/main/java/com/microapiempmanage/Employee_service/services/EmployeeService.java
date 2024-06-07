package com.microapiempmanage.Employee_service.services;

import com.microapiempmanage.Employee_service.entities.Employee;
import com.microapiempmanage.Employee_service.entities.ProjectWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface EmployeeService {


    List<Employee> getEmployees();

    Employee getEmployee(Integer empId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Integer empId, Employee employee);

    ResponseEntity<String> deleteEmployee(Integer empId);
    ResponseEntity<?> assignProjectToEmployee(Integer empId,Integer projectId);
    ResponseEntity<?> assignDepartmentToEmployee(Integer empId, Integer deptId);

}