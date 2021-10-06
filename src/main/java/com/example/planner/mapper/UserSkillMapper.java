package com.example.planner.mapper;

import com.example.planner.dto.UserSkillDto;
import com.example.planner.model.UserSkill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserSkillMapper {

    UserSkillMapper INSTANCE = Mappers.getMapper(UserSkillMapper.class);
    List<UserSkillDto> allSkillsToSkillDto(List<UserSkill> userSkillDto);
}
