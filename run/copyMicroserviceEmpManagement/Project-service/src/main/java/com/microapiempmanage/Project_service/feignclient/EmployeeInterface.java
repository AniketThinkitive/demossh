package com.microapiempmanage.Project_service.feignclient;

import com.microapiempmanage.Project_service.entities.EmployeeWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name ="Employee-service", url = "http://localhost:8081/emp")// Name of the microservice to communicate with
public interface EmployeeInterface {

@GetMapping("/getEmployees")
public ResponseEntity<List<EmployeeWrapper>> getEmployees();


@GetMapping("/getEmployee/{empId}")
public ResponseEntity<EmployeeWrapper> getEmployee(@PathVariable Integer empId);

@PutMapping("/assignProject/{empId}/{projectId}")
public ResponseEntity<String> assignProjectToEmployee(@PathVariable Integer empId, @PathVariable Integer projectId) ;


//    @PutMapping("/assignDepartment/{empId}/dept/{deptId}")
//    ResponseEntity<?> assignDepartmentToEmployee(@PathVariable UUID empId, @PathVariable UUID deptId);
}