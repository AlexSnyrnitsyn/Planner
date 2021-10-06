package com.example.planner.service;

import com.example.planner.dto.UserDto;
import com.example.planner.dto.UserSkillDto;
import com.example.planner.model.UserSkill;

import java.util.List;

public interface UserSkillService {

    List<UserSkillDto> getAllUserSkill();

    UserSkill getUserSkillById(Long id);

    void createUserSkill(UserSkillDto userSkillDto);

    void updateUserSkill(UserSkillDto userSkillDto, Long id);

    void deleteUserSkill(Long id);

}
