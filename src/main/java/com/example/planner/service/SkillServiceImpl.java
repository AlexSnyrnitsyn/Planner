package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.mapper.SkillMapper;
import com.example.planner.model.Skill;
import com.example.planner.repository.SkillRepository;
import com.example.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void addSkill(SkillDto newSkill) {

        Skill skill = SkillMapper.INSTANCE.skillDtoToSkill(newSkill);
        skillRepository.save(skill);

    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);

    }

    @Override
    public void updateSkill(SkillDto newSkill, Long id) {

        skillRepository.findById(id).map(skill -> {
            skill.setSkillName(newSkill.getSkillName());
            skill.setDescription(newSkill.getDescription());
            return skillRepository.save(skill);
        });
    }
}
