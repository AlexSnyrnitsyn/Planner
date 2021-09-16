package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.error.ServiceException;
import com.example.planner.model.Position;
import com.example.planner.model.Skill;
import com.example.planner.model.Subdivision;
import com.example.planner.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    
    User getById(Long id);

    void createUser(UserDto user) throws ServiceException;

    void updateUser(UserDto user, Long id);

    void deleteUser(Long id);

    void updatePosition(Long userId, Long positionId) throws ServiceException;

    void updateSubdivision(Long userId, Long subdivisionId) throws ServiceException;

}
