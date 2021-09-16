package com.example.planner.mapper;

import com.example.planner.dto.SkillDto;
import com.example.planner.model.Skill;
import org.mapstruct.factory.Mappers;

public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);
    Skill skillDtoToSkill(SkillDto skillDto);
}
