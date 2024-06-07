package com.microapiempmanage.Project_service.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="projectId")
    private int projectId;
    private UUID puuid;
    private String projectName;
    private int empId;




//        @OneToMany(mappedBy = "departments")
//        private Set<Department> departments;
//        @OneToMany(mappedBy = "projects")
//        private Set<Employee> employees;

    //////cg
    @ManyToOne
    @JoinColumn(name="project_deptId")
    @JsonBackReference
    private Department department;

//
//    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @ElementCollection
//    private List<Integer> employees =new ArrayList<>();

//
//    @ElementCollection
//    private List<Integer> employees ;

}
