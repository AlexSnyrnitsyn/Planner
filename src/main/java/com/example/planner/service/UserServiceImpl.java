package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.enums.ResponseCode;
import com.example.planner.error.ServiceException;
import com.example.planner.mapper.SkillMapper;
import com.example.planner.mapper.UserMapper;
import com.example.planner.model.*;
import com.example.planner.repository.PositionRepository;
import com.example.planner.repository.SkillRepository;
import com.example.planner.repository.SubdivisionRepository;
import com.example.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    PositionRepository positionRepository;
    SubdivisionRepository subdivisionRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(UserDto newUser) throws ServiceException  {

        User user = UserMapper.INSTANCE.userDtoToUser(newUser);
        Position position = positionRepository.getById(newUser.getPositionId());
            if(position == null) {
                throw new ServiceException(ResponseCode.WRONG_POSITION);
        }
        Subdivision subdivision = subdivisionRepository.getById(newUser.getSubdivisionId());
            if(subdivision == null) {
                throw new ServiceException(ResponseCode.WRONG_SUBDIVISION);
        }
        user.setUserPosition(position);
        user.setUserSubdivision(subdivision);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDto newUser, Long id) {

        userRepository.findById(id).map(user -> {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            return userRepository.save(user);
        });
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public void updatePosition(Long userId, Long positionId) throws ServiceException {

        User user = userRepository.getById(userId);
        Position position = positionRepository.getById(positionId);
        if(position == null) {
            throw new ServiceException(ResponseCode.WRONG_POSITION);
        }

        user.setUserPosition(position);
        userRepository.save(user);
    }

    @Override
    public void updateSubdivision(Long userId, Long subdivisionId) throws ServiceException {

        User user = userRepository.getById(userId);
        Subdivision subdivision = subdivisionRepository.getById(subdivisionId);
        if(subdivision == null) {
            throw new ServiceException(ResponseCode.WRONG_SUBDIVISION);
        }

        user.setUserSubdivision(subdivision);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        return UserMapper.INSTANCE.allUsersToUserDto(userRepository.findAll());
    }
}
