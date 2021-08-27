package com.example.planner.service;

import com.example.planner.dto.UserDto;
import com.example.planner.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    
    User getById(Long id);

    void createUser(UserDto user);

    void updateUser(UserDto user, Long id);

    void deleteUser(Long id);

}
