package com.example.planner.service;

import com.example.planner.dto.UserCreateDto;
import com.example.planner.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    
    User getById(Long id);

    void createUser(UserCreateDto user);

    void updateUser(UserCreateDto user, Long id);

    void deleteUser(Long id);

}
