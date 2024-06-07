package com.microapiempmanage.Employee_service.entities;

import lombok.*;

import java.util.UUID;



@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ProjectWrapper {


    private int projectId;
    private UUID puuid;
    private String projectName;

}
