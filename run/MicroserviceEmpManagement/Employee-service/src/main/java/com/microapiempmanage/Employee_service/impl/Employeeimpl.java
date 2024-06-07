package com.microapiempmanage.Employee_service.impl;

//import com.microapiempmanage.Employee_service.dto.ProjectDto;
import com.microapiempmanage.Employee_service.entities.Employee;

//import com.microapiempmanage.Employee_service.dto.ProjectWrapper;
import com.microapiempmanage.Employee_service.entities.ProjectWrapper;
import com.microapiempmanage.Employee_service.feignclient.ProjectInterface;
import com.microapiempmanage.Employee_service.repository.EmployeeRepository;

import com.microapiempmanage.Employee_service.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class Employeeimpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    private final ProjectInterface projectInterface;

    public Employeeimpl(ProjectInterface projectInterface) {
        this.projectInterface = projectInterface;
    }


//    @Autowired
//    ProjectRepository projectRepository;
//
//    @Autowired
//    DepartmentRepository departmentRepository;


    @Override
    public List<Employee> getEmployees() {
        List<Employee> elist=employeeRepository.findAll();
        return elist;
    }

    @Override
    public Employee getEmployee(Integer empId) {
        Employee e1=employeeRepository.findById(empId).get();
        return e1;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        UUID uid = UUID.randomUUID();
        employee.setEuuid(uid);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer empId, Employee newEmployee) {
        Employee oldEmployee= employeeRepository.findById(empId).get();
        oldEmployee.setEmpName(newEmployee.getEmpName());
        return employeeRepository.save(oldEmployee);

    }

    @Override
    public ResponseEntity<String> deleteEmployee(Integer empId) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findById(empId).get());

        if (optionalEmployee.isPresent()) {
            Employee employeeToDelete = optionalEmployee.get();
            // Delete the employee
            employeeRepository.delete(employeeToDelete);
            return ResponseEntity.ok("Employee deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @Override
//    public ResponseEntity<?> assignProjectToEmployee(Integer empId, Integer projectId) {
//        Employee employee = employeeRepository.findById(empId).get();
//        ProjectWrapper project = projectInterface.getProject(projectId);
//        employee.setProjectWrapper(project);
//         employeeRepository.save(employee);
//         return ResponseEntity.ok("Assigned project");
//    }

//    @Override
//    public ResponseEntity<?> assignProjectToEmployee(Integer empId, Integer projectId) {
//        Employee employee = employeeRepository.findById(empId).get();
//        ProjectWrapper project = projectInterface.getProject(projectId).getBody();
//        employee.setProjectWrapper(project);
//        employeeRepository.save(employee);
//        return ResponseEntity.ok("Assigned project");
//    }



    @Override
    public ResponseEntity<String> assignProjectToEmployee(Integer empId, Integer projectId) {
        Employee employee = employeeRepository.findById(empId).orElse(null);
        ProjectWrapper project = projectInterface.getProject(projectId).getBody();
        employee.setProjectId(projectId);
        employeeRepository.save(employee);
        return ResponseEntity.ok("Assigned project");


    }
//    @Override
//    public ResponseEntity<?> assignProjectToEmployee(Integer empId, Integer projectId) {
//        Employee employee = employeeRepository.findById(empId).get();
//        ProjectWrapper projectid= projectInterface.findById(projectId);
//        employee.setProjectId(projectid.getProjectId());
//        employeeRepository.save(employee);
//        return ResponseEntity.ok("Assigned project");
//    }




//    @Override
//    public ResponseEntity<?> assignProjectToEmployee(Integer empId, Integer projectId) {
//        Optional<Employee> employee = employeeRepository.findById(empId); // Retrieve employee by ID
//
//
////        // Retrieve the ProjectDto from the Feign client
////        ResponseEntity<?> project = projectInterface.getProject(projectId); // Retrieve project by ID
////
////
////        // Convert ProjectDto to ProjectWrapper (if necessary)
////
////        // Set the ProjectWrapper to the Employee
////        employee.setProjectWrapper(projectWrapper);
////
////        // Save the updated employee
////        employeeRepository.save(employee);
////
////        return ResponseEntity.ok("Assigned project"); // Return success response
////    }










    @Override
    public ResponseEntity<?> assignDepartmentToEmployee(Integer empId, Integer deptId) {
        Employee employee = employeeRepository.findById(empId).get();
//        Department department=departmentRepository.findById(deptId);
//        employee.setDepartment(department);
        employeeRepository.save(employee);
        return ResponseEntity.ok("Assigned Department");
    }

    public ResponseEntity<List<ProjectWrapper>> getProjects() {
        ResponseEntity<List<ProjectWrapper>> projects=projectInterface.getProjects();
        return projects;
    }

    public ResponseEntity<ProjectWrapper> getProject(Integer projectId) {
   ResponseEntity<ProjectWrapper> project=projectInterface.getProject(projectId);
   return project;
    }


//    public ResponseEntity<?> assignDepartmentToEmployee(UUID empId, UUID deptId) {
//        Employee employee = employeeRepository.findByEuuid(empId);
//        Department department = departmentRepository.findByDuuid(deptId);
//
//        // Assign the department to the employee
//        employee.setDepartment(department);
//        employeeRepository.save(employee);
//
//        // Also, add the employee to the department's list of employees
//        List<Employee> employees = department.getEmployees();
//        employees.add(employee);
//        department.setEmployees(employees);
//        departmentRepository.save(department);
//
//        return ResponseEntity.ok("Assigned Department");
//    }
//









}
