package com.microapiempmanage.Project_service.services;


import com.microapiempmanage.Project_service.entities.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProjectServices {

    List<Project> getProjects();
    Project getProject(Integer projectId);
    Project addProject(Project project);
    Project updateProject(Integer projectId,Project Project);
    ResponseEntity<String> deleteProject(Integer projectId);
    ResponseEntity<?> assignDepartmentToProject(Integer projectId,Integer deptId);


}
