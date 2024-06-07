package com.microapiempmanage.Project_service.controller;



import com.microapiempmanage.Project_service.dto.ProjectDto;
import com.microapiempmanage.Project_service.entities.EmployeeWrapper;
import com.microapiempmanage.Project_service.entities.Project;
import com.microapiempmanage.Project_service.impl.Projectimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjController {

    private final Projectimpl projectimpl;

    @Autowired
    public ProjController(Projectimpl projectimpl) {
        this.projectimpl = projectimpl;
    }

    @GetMapping("/getProjects")
    public List<ProjectDto> getProjects() {
        List<Project> projects = projectimpl.getProjects();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Project project : projects) {
            projectDtos.add(convertToDto(project));
        }
        return projectDtos;
    }


    @PostMapping("/addProject")
    public ProjectDto addProject(@RequestBody ProjectDto projDto) {
        Project project = convertToEntity(projDto);
        return convertToDto(projectimpl.addProject(project));
    }

    @GetMapping("/getProject/{projectId}")
    public ProjectDto getProject(@PathVariable Integer projectId) {
        Project project = projectimpl.getProject(projectId);
        return convertToDto(project);
    }

    @PutMapping("/updateProject/{projectId}")
    public ProjectDto updateProject(@PathVariable Integer projectId, @RequestBody ProjectDto projDto) {
        Project project = convertToEntity(projDto);
        return convertToDto(projectimpl.updateProject(projectId, project));
    }

    @DeleteMapping("/deleteProject/{projectId}")
    @Transactional
    public ResponseEntity<String> deleteProject(@PathVariable Integer projectId) {
        return projectimpl.deleteProject(projectId);
    }

    @PutMapping("/assignDepartment/{projectId}/dept/{deptId}")
    @Transactional
    public ResponseEntity<?> assignDepartmentToProject(@PathVariable Integer projectId, @PathVariable Integer deptId) {
        return projectimpl.assignDepartmentToProject(projectId, deptId);
    }


    @PutMapping("/assignProject/{empId}/{projectId}")
    public ResponseEntity<?> assignProjectToEmployee(@PathVariable Integer empId, @PathVariable Integer projectId) {
        return projectimpl.assignProjectToEmployee(empId, projectId);
    }


    @PutMapping("/assignEmployeeToProject/{empId}/{projectId}")
    public ResponseEntity<?> assignEmployeeToProject(@PathVariable Integer empId, @PathVariable Integer projectId) {
        return projectimpl.assignEmployeeToProject(empId, projectId);
    }
    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<EmployeeWrapper> getEmployee(@PathVariable Integer empId) {
              return projectimpl.getEmployee(empId);
    }



    @GetMapping("/getEmployees")
    public ResponseEntity<List<EmployeeWrapper>> getEmployee() {
        return projectimpl.getEmployees();
    }







    // Converting ProjDto to Project entity
    private Project convertToEntity(ProjectDto projDto) {
        Project project = new Project();
        project.setPuuid(projDto.getPuuid());
        project.setProjectId(projDto.getProjectId());
        project.setProjectName(projDto.getProjectName());

        return project;
    }

    // Converting Project entity to ProjDto
    private ProjectDto convertToDto(Project project) {
        ProjectDto projDto = new ProjectDto();
        projDto.setPuuid(project.getPuuid());
        projDto.setProjectId(project.getProjectId());
        projDto.setProjectName(project.getProjectName());

        return projDto;
    }
}
