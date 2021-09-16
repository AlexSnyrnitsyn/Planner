package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.model.Skill;

public interface SkillService {

    Skill getSkillById(Long id);

    void addSkill(SkillDto skill);

    void deleteSkill(Long id);

    void updateSkill (SkillDto skill, Long id);

}
