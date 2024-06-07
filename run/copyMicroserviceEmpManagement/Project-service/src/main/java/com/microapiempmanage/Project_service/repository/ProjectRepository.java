package com.microapiempmanage.Project_service.repository;



import com.microapiempmanage.Project_service.entities.Project;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
public interface ProjectRepository extends JpaRepository<Project,Integer> {



//    Project deleteByPuuid(UUID projectId);

//    Project findByPuuid(UUID projectId);

//    List<Integer> getEmployee(UUID empId);
}
