package com.example.planner.service;

import com.example.planner.dto.UserSkillDto;
import com.example.planner.error.ServiceException;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.model.UserSkill;

public interface UserSkillService {

    UserSkill getUserSkillById(Long id);

    void createUserSkill(UserSkillDto userSkillDto) throws ServiceException;

    void updateUserSkill(UserSkillDto userSkillDto, Long id) throws ServiceException;

    void deleteUserSkill(Long id);

}
