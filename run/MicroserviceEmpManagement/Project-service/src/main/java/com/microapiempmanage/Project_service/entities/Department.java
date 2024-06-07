package com.microapiempmanage.Project_service.entities;


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
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="deptId")
    private int deptId;
    private UUID duuid;
    private String deptName;

//
//    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();




}

