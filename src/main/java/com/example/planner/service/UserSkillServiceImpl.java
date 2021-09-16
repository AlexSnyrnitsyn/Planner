package com.example.planner.service;

import com.example.planner.dto.UserSkillDto;
import com.example.planner.enums.ResponseCode;
import com.example.planner.error.ServiceException;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.model.UserSkill;
import com.example.planner.repository.SkillRepository;
import com.example.planner.repository.UserRepository;
import com.example.planner.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillServiceImpl implements UserSkillService {

    @Autowired
    UserSkillRepository userSkillRepository;
    UserRepository userRepository;
    SkillRepository skillRepository;


    @Override
    public UserSkill getUserSkillById(Long id) {
        return userSkillRepository.findById(id).orElse(null);
    }

    @Override
    public void createUserSkill(UserSkillDto userSkillDto) throws ServiceException {

        User user = userRepository.getById(userSkillDto.getUserId());
                if(user == null) {
                    throw new ServiceException(ResponseCode.WRONG_USER);
                }

        Skill skill = skillRepository.getById(userSkillDto.getSkillId());
                if (skill == null) {
                    throw new ServiceException(ResponseCode.WRONG_SKILL);
                }

        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setGrade(userSkillDto.getGrade());

        userSkillRepository.save(userSkill);
    }

    @Override
    public void updateUserSkill(UserSkillDto newUserSkillDto, Long id) throws ServiceException {

        UserSkill userSkill = userSkillRepository.getById(id);
            if (userSkill == null) {
                throw new ServiceException(ResponseCode.WRONG_USER_SKILL);
            }
        userSkill.setGrade(newUserSkillDto.getGrade());
        userSkillRepository.save(userSkill);
    }

    @Override
    public void deleteUserSkill(Long id) {
        userSkillRepository.deleteById(id);
    }
}
