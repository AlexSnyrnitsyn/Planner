package com.example.planner.mapper;

import com.example.planner.dto.UserDto;
import com.example.planner.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
        User userDtoToUser(UserDto userDto);

        @Mappings({
        @Mapping(target = "password", ignore = true),
        @Mapping(source = "positionId", target = "user.userPosition.id"),
        @Mapping(source = "subdivisionId", target = "user.userSubdivision.id")
        })
        List<UserDto> allUsersToUserDto(List<User> user);
        
    }

