package com.example.planner.service;

import com.example.planner.dto.UserCreateDto;
import com.example.planner.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    void createUser(UserCreateDto user);

    void updateUser(UserCreateDto user, Long id);

    void deleteUser(Long id);

    List<User> getAllUsers();
}
