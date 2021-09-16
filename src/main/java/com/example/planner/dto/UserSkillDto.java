package com.example.planner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSkillDto {

    private Long userId;
    private Long skillId;
    private int grade;

}
