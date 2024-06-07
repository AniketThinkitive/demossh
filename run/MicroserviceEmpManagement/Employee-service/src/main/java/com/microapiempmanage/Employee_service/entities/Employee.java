package com.microapiempmanage.Employee_service.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="empId")
    private int empId;
    private UUID euuid;
    private String empName;
    private int projectId;

//    public Integer setProjectWrapper(ProjectWrapper project) {
//
//    return  0;}

//    @ManyToOne
//    private ProjectWrapper projectWrapper;


//    @ElementCollection
//    private ProjectWrapper projectWrapper;


//
//    @ManyToOne
//    @JoinColumn(name="emp_deptId")
//    @JsonBackReference
//    private Department department;
//
////
//    @ManyToOne
//    @JoinColumn(name="emp_projectId")
//    @JsonBackReference
//    private ProjectWrapper projectWrapper;

//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }


//    @JoinColumn(name="emp_deptId")
//    @JsonBackReference
//    @ElementCollection
//    private List<Integer> department;
//
//
//
//    @JoinColumn(name="emp_projectId")
//    @JsonBackReference
//    @ElementCollection
//    private List<Integer> project;








}
