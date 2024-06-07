package com.microapiempmanage.Project_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeptDto {

    private int deptId;
    private UUID duuid;
    private String deptName;
}
