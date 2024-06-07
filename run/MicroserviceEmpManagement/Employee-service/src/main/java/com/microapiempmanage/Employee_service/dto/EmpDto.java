package com.microapiempmanage.Employee_service.dto;

import com.microapiempmanage.Employee_service.entities.ProjectWrapper;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Transient;
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

public class EmpDto {
    private int empId;
    private UUID euuid;
    private String empName;
    private int deptId;
    private int projectId;




//
//    @ElementCollection
//    private List<Integer> projectDto;



//    private ProjectWrapper projectDto;

//    private Department department;
//    private Project project;
//




}
