package com.example.planner.service;

import com.example.planner.dto.UserSkillDto;
import com.example.planner.model.UserSkill;

public class TestData {

    public static UserSkillDto getUserSkill(){

        UserSkillDto userSkillDto = new UserSkillDto();

        userSkillDto.setId(1L);
        userSkillDto.setGrade(4);
        userSkillDto.setUserId(1L);
        userSkillDto.setSkillId(1L);

        return userSkillDto;

    }
}
