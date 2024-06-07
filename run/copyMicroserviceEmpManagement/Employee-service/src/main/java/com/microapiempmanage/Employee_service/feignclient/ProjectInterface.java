package com.microapiempmanage.Employee_service.feignclient;



//import com.microapiempmanage.Employee_service.dto.ProjectWrapper;
import com.microapiempmanage.Employee_service.entities.ProjectWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name ="Project-service", url = "http://localhost:8082/project")// Name of the microservice to communicate with
public interface ProjectInterface {

//    @GetMapping("/assignProject/{projectId}")
//   public  ProjectWrapper findById(Integer projectId);



    @GetMapping("/getProjects")
    public ResponseEntity<List<ProjectWrapper>> getProjects();


    @GetMapping("/getProject/{projectId}")
   public ResponseEntity<ProjectWrapper> getProject(@PathVariable Integer projectId);







//    @GetMapping
//    ProjectWrapper findById(Integer projectId);


//    ProjectWrapper findById(Integer projectId);
//    @GetMapping("/assignProject/{empId}/{projectId}") // Define the endpoint to retrieve a project by ID
//    ProjectWrapper getProject(@PathVariable  Integer empId,@PathVariable Integer projectId);
//
//    @GetMapping("/assignProject/{empId}/{projectId}")
//    ProjectWrapper findById(Integer projectId);

//    ProjectDto findById(Integer projectId);


//    ProjectWrapper findById(Integer projectId);
}