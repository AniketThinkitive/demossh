package com.microapiempmanage.Project_service.impl;


import com.microapiempmanage.Project_service.entities.Department;
import com.microapiempmanage.Project_service.entities.EmployeeWrapper;
import com.microapiempmanage.Project_service.entities.Project;
import com.microapiempmanage.Project_service.feignclient.EmployeeInterface;
import com.microapiempmanage.Project_service.repository.DepartmentRepository;
import com.microapiempmanage.Project_service.repository.ProjectRepository;
import com.microapiempmanage.Project_service.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class Projectimpl implements ProjectServices {



    private final EmployeeInterface employeeInterface;




    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    public Projectimpl(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }


    @Override
    public List<Project> getProjects() {
        List<Project> plist = projectRepository.findAll();
        return plist;

    }

    @Override
    public Project getProject(Integer projectId) {
        Project p1 = projectRepository.findById(projectId).get();
        return p1;
    }

    @Override
    public Project addProject(Project project) {
        UUID uid = UUID.randomUUID();
        project.setPuuid(uid);
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Integer projectId, Project project) {
        Project p= projectRepository.findById(projectId).get();
        p.setProjectName(project.getProjectName());
        return projectRepository.save(p);

    }

    @Override
    public ResponseEntity<String> deleteProject(Integer projectId) {
        Optional<Project> optionalProject = Optional.ofNullable(projectRepository.findById(projectId).get());

        if (optionalProject.isPresent()) {
            Project projectToDelete = optionalProject.get();
            projectRepository.delete(projectToDelete);
            return ResponseEntity.ok("Project deleted successfully.");
        } else {
            return ResponseEntity.notFound().build(); // Project not found
        }

    }



    @Override
    @Transactional
    public ResponseEntity<?> assignDepartmentToProject(Integer projectId, Integer deptId) {
        Project project=projectRepository.findById(projectId).get();
        Department department=departmentRepository.findById(deptId).get();
        project.setDepartment(department);
        projectRepository.save(project);
        return ResponseEntity.ok("Assigned Deparment");
    }


    public ResponseEntity<?> assignProjectToEmployee(Integer empId, Integer projectId) {
      ResponseEntity<?> response = employeeInterface.assignProjectToEmployee(empId, projectId);
    return response;
   }


////////main
//    public ResponseEntity<EmployeeWrapper> assignProjectToEmployee(Integer empId,Integer projectId) {
////        Project project = projectRepository.findById(projectId).get();
//      return   ResponseEntity<EmployeeWrapper>   = employeeInterface.assignProjectToEmployee(empId, projectId);
//        return response;
//    }

    public ResponseEntity<List<EmployeeWrapper>> getEmployees() {

        ResponseEntity<List<EmployeeWrapper>> emps=employeeInterface.getEmployees();
        return  emps;
    }

    public ResponseEntity<EmployeeWrapper> getEmployee(Integer empId) {
        ResponseEntity<EmployeeWrapper> employee=employeeInterface.getEmployee(empId);
    return  employee;
    }

    public ResponseEntity<?> assignEmployeeToProject(Integer empId, Integer projectId) {

        Project project = projectRepository.findById(projectId).get();
        EmployeeWrapper empid= employeeInterface.getEmployee(empId).getBody();
        project.setEmpId(empId);
        projectRepository.save(project);
        return ResponseEntity.ok("Assigned Employee");


//        Project project=projectRepository.findById(projectId).get();
////        Department department=departmentRepository.findById(deptId).get();
//        EmployeeWrapper employeeWrapper=employeeInterface.getEmployee(empId).getBody();
//       EmployeeWrapper employeeWrapper=employeeInterface.assignProjectToEmployee()
//        project.setDepartment(department);
//        projectRepository.save(project);
//        return ResponseEntity.ok("Assigned Deparment");
    }
}