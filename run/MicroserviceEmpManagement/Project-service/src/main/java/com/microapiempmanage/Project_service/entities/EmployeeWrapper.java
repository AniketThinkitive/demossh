package com.microapiempmanage.Project_service.entities;


import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class EmployeeWrapper {

    private int empId;
    private UUID euuid;
    private String empName;

}
