package com.microapiempmanage.Project_service.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProjectDto {
    private int projectId;
    private UUID puuid;
    private String projectName;
    private int deptId;
    private int empId;





//    @ElementCollection
//    private List<Integer> employees ;

}
