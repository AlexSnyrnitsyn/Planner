package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.mapper.SkillMapper;
import com.example.planner.model.Skill;
import com.example.planner.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<SkillDto> getAllSkill() {

        return SkillMapper.INSTANCE.allSkillsToSkillDto(skillRepository.findAll());

    }


    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);

    }

    @Override
    public void createSkill(SkillDto newSkill) {

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
