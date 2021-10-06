package com.example.planner.mapper;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);
    Skill skillDtoToSkill(SkillDto skillDto);
    List<SkillDto> allSkillsToSkillDto(List<Skill> skillDto);
}
