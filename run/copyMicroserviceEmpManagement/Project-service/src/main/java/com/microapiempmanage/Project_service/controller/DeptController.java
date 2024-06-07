package com.microapiempmanage.Project_service.controller;

import com.microapiempmanage.Project_service.dto.DeptDto;
import com.microapiempmanage.Project_service.entities.Department;
import com.microapiempmanage.Project_service.impl.Departmentimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final Departmentimpl departmentimpl;

    @Autowired
    public DeptController(Departmentimpl departmentimpl)
    {
        this.departmentimpl = departmentimpl;
    }

    @PostMapping("/addDept")
    public Department addDept(@RequestBody DeptDto deptDto)
    {
        return departmentimpl.addDept(convertToEntity(deptDto));
    }

    @GetMapping("/getDept/{deptId}")
    public DeptDto getDept(@PathVariable Integer deptId) {
        Department department = departmentimpl.getDept(deptId);
        return convertToDto(department);
    }

    @GetMapping("/getDepts")
    public List<DeptDto> getDepts() {
        List<Department> departments = departmentimpl.getDepts();
        List<DeptDto> deptDtos = new ArrayList<>();
        for (Department department : departments) {
            deptDtos.add(convertToDto(department));
        }
        return deptDtos;
    }

    @DeleteMapping("/deleteDept/{deptId}")
    public ResponseEntity<String> deleteDept(@PathVariable Integer deptId)
    {
        return departmentimpl.deleteDept(deptId);
    }

    @PutMapping("/updateDept/{deptId}")
    public Department updateDept(@PathVariable Integer deptId, @RequestBody DeptDto deptDto) {
        return departmentimpl.updateDept(deptId, convertToEntity(deptDto));
    }
    // Converting DeptDto to Department entity
    private Department convertToEntity(DeptDto deptDto) {
        Department department = new Department();
        department.setDeptId(deptDto.getDeptId()); // Generating a UUID for the new Department
        department.setDuuid(deptDto.getDuuid());
        department.setDeptName(deptDto.getDeptName());
                return department;
    }

    // Converting Department entity to DeptDto
    private DeptDto convertToDto(Department department) {
        DeptDto deptDto = new DeptDto();
        deptDto.setDeptId(department.getDeptId());
        deptDto.setDuuid(department.getDuuid());
        deptDto.setDeptName(department.getDeptName());
        return deptDto;
    }

}
