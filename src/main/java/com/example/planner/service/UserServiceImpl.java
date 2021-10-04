package com.example.planner.service;

import com.example.planner.dto.UserDto;
import com.example.planner.enums.ResponseCode;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.mapper.UserMapper;
import com.example.planner.model.*;
import com.example.planner.repository.PositionRepository;
import com.example.planner.repository.SubdivisionRepository;
import com.example.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    SubdivisionRepository subdivisionRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(UserDto newUser) {

        User user = UserMapper.INSTANCE.userDtoToUser(newUser);
        Position position = positionRepository.getById(newUser.getPositionId());
            if(position == null) {
                throw new EntityNotFoundException(ResponseCode.POSITION_NOT_FOUND);
        }
        Subdivision subdivision = subdivisionRepository.getById(newUser.getSubdivisionId());
            if(subdivision == null) {
                throw new EntityNotFoundException(ResponseCode.SUBDIVISION_NOT_FOUND);
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
    public void updatePosition(Long userId, Long positionId) {

        User user = userRepository.getById(userId);
        Position position = positionRepository.getById(positionId);
        if(position == null) {
            throw new EntityNotFoundException(ResponseCode.POSITION_NOT_FOUND);
        }

        user.setUserPosition(position);
        userRepository.save(user);
    }

    @Override
    public void updateSubdivision(Long userId, Long subdivisionId) {

        User user = userRepository.getById(userId);
        Subdivision subdivision = subdivisionRepository.getById(subdivisionId);
        if(subdivision == null) {
            throw new EntityNotFoundException(ResponseCode.SUBDIVISION_NOT_FOUND);
        }

        user.setUserSubdivision(subdivision);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        return UserMapper.INSTANCE.allUsersToUserDto(userRepository.findAll());
    }
}
