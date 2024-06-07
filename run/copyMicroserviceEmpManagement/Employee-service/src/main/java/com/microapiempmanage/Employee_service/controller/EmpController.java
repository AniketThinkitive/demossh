
package com.microapiempmanage.Employee_service.controller;


import com.microapiempmanage.Employee_service.dto.EmpDto;
import com.microapiempmanage.Employee_service.entities.Employee;
import com.microapiempmanage.Employee_service.entities.ProjectWrapper;
import com.microapiempmanage.Employee_service.impl.Employeeimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/emp")
public class  EmpController {

    private final Employeeimpl employeeimpl;

    @Autowired
    public EmpController(Employeeimpl employeeimpl) {
        this.employeeimpl = employeeimpl;
    }

    @PostMapping("/addEmployee")
    public EmpDto addEmployee(@RequestBody EmpDto empDto) {
        Employee newEmployee = convertToEntity(empDto);
        Employee addedEmployee = employeeimpl.addEmployee(newEmployee);
        return convertToDto(addedEmployee);
    }

    @GetMapping("/getEmployee/{empId}")
    public EmpDto getEmployee(@PathVariable Integer empId) {
        Employee employee = employeeimpl.getEmployee(empId);
        return convertToDto(employee);
    }

    @GetMapping("/getEmployees")
    public List<EmpDto> getEmployees() {
        List<Employee> employees = employeeimpl.getEmployees();
        List<EmpDto> empDtos = new ArrayList<>();
        for (Employee employee : employees) {
            empDtos.add(convertToDto(employee));
        }
        return empDtos;
    }


    @DeleteMapping("/deleteEmployee/{empId}")
    @Transactional
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) {
        return employeeimpl.deleteEmployee(empId);
    }

    @PutMapping("/updateEmployee/{empId}")
    public EmpDto updateEmployee(@PathVariable Integer empId, @RequestBody EmpDto empDto) {
        Employee updatedEmployee = employeeimpl.updateEmployee(empId, convertToEntity(empDto));
        return convertToDto(updatedEmployee);
    }

    @PutMapping("/assignProject/{empId}/{projectId}")
    public ResponseEntity<String> assignProjectToEmployee(@PathVariable Integer empId, @PathVariable Integer projectId) {
        return (ResponseEntity<String>) employeeimpl.assignProjectToEmployee(empId, projectId);
    }



//    @PutMapping("/assignProject/{empId}/{projectId}")
//    public String assignProjectToEmployee(@PathVariable Integer empId, @PathVariable Integer projectId) {
// return employeeimpl.assignProjectToEmployee(empId, projectId);
////  return "projectassign";
//    }

    @PutMapping("/assignDepartment/{empId}/dept/{deptId}")
    public ResponseEntity<?> assignDepartmentToEmployee(@PathVariable Integer empId, @PathVariable Integer deptId) {
        return employeeimpl.assignDepartmentToEmployee(empId, deptId);
    }



    @GetMapping("/getProjects")
    public ResponseEntity<List<ProjectWrapper>> getProjects() {
//        List<Project> projects = projectimpl.getProjects();
//        List<ProjectDto> projectDtos = new ArrayList<>();
//        for (Project project : projects) {
//            projectDtos.add(convertToDto(project));
//        }
//        return projectDtos;

        return employeeimpl.getProjects();
    }


    @GetMapping("/getProject/{projectId}")
    public ResponseEntity<ProjectWrapper> getProject(@PathVariable Integer projectId) {
        return  employeeimpl.getProject(projectId);

    }












    // Converting Emp DTO to Employee entity
    private Employee convertToEntity(EmpDto empDto) {
        Employee employee = new Employee();
        employee.setEmpId(empDto.getEmpId());
        employee.setEuuid(empDto.getEuuid());
        employee.setEmpName(empDto.getEmpName());

        return employee;
    }

    // Converting entity to DTO
    private EmpDto convertToDto(Employee employee) {
        EmpDto empDto = new EmpDto();
        empDto.setEmpId(employee.getEmpId());
        empDto.setEuuid(employee.getEuuid());
        empDto.setEmpName(employee.getEmpName());

        return empDto;
    }
}
