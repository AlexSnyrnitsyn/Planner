package com.example.planner.service;

import com.example.planner.dto.UserSkillDto;
import com.example.planner.enums.ResponseCode;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.mapper.UserMapper;
import com.example.planner.mapper.UserSkillMapper;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.model.UserSkill;
import com.example.planner.repository.SkillRepository;
import com.example.planner.repository.UserRepository;
import com.example.planner.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillServiceImpl implements UserSkillService {

    @Autowired
    UserSkillRepository userSkillRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SkillRepository skillRepository;


    @Override
    public List<UserSkillDto> getAllUserSkill() {

        return UserSkillMapper.INSTANCE.allSkillsToSkillDto(userSkillRepository.findAll());
    }

    @Override
    public UserSkill getUserSkillById(Long id) {
        return userSkillRepository.findById(id).orElse(null);
    }

    @Override
    public void createUserSkill(UserSkillDto userSkillDto) {

        User user = userRepository.getById(userSkillDto.getUserId());
                if(user == null) {
                    throw new EntityNotFoundException(ResponseCode.USER_NOT_FOUND);
                }

        Skill skill = skillRepository.getById(userSkillDto.getSkillId());
                if (skill == null) {
                    throw new EntityNotFoundException(ResponseCode.SKILL_NOT_FOUND);
                }

        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setGrade(userSkillDto.getGrade());

        userSkillRepository.save(userSkill);
    }

    @Override
    public void updateUserSkill(UserSkillDto newUserSkillDto, Long id) {

        UserSkill userSkill = userSkillRepository.getById(id);
            if (userSkill == null) {
                throw new EntityNotFoundException(ResponseCode.USER_SKILL_NOT_FOUND);
            }
        userSkill.setGrade(newUserSkillDto.getGrade());
        userSkillRepository.save(userSkill);
    }

    @Override
    public void deleteUserSkill(Long id) {
        userSkillRepository.deleteById(id);
    }
}
