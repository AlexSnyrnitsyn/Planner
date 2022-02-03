package com.example.planner.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class ProjectDto {

    private Long id;
    private String projectName;
    private String goalProject;
    private String complexityProject;

}
