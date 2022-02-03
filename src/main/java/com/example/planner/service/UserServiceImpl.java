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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PositionRepository positionRepository, SubdivisionRepository subdivisionRepository) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.subdivisionRepository = subdivisionRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(UserDto newUser) {

        User user = UserMapper.INSTANCE.userDtoToUser(newUser);
        Position position = positionRepository.findById(newUser.getPositionId()).orElseThrow(()-> new EntityNotFoundException(ResponseCode.POSITION_NOT_FOUND));

        Subdivision subdivision = subdivisionRepository.findById(newUser.getSubdivisionId()).orElseThrow(()-> new EntityNotFoundException(ResponseCode.SUBDIVISION_NOT_FOUND));

        user.setRole(Collections.singleton(new Role(1L, "ROLE_USER")));
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
        Position position = positionRepository.findById(positionId).orElseThrow(()-> new EntityNotFoundException(ResponseCode.POSITION_NOT_FOUND));

        user.setUserPosition(position);
        userRepository.save(user);
    }

    @Override
    public void updateSubdivision(Long userId, Long subdivisionId) {

        User user = userRepository.getById(userId);
        Subdivision subdivision = subdivisionRepository.findById(subdivisionId).orElseThrow(()-> new EntityNotFoundException(ResponseCode.SUBDIVISION_NOT_FOUND));

        user.setUserSubdivision(subdivision);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        return UserMapper.INSTANCE.allUsersToUserDto(userRepository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
