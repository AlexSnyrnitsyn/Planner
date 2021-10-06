package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Skill;

import java.util.List;

public interface SkillService {

    List<SkillDto> getAllSkill();

    Skill getSkillById(Long id);

    void createSkill(SkillDto skill);

    void deleteSkill(Long id);

    void updateSkill (SkillDto skill, Long id);

}
