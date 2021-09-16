package com.example.planner.mapper;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
        User userDtoToUser(UserDto userDto);

        @Mapping(target = "password", ignore = true)
        List<UserDto> allUsersToUserDto(List<User> userDto);

    }

