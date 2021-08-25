package com.example.planner.service;

import com.example.planner.dto.UserCreateDto;
import com.example.planner.model.User;
import com.example.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(UserCreateDto newUser) {
        User user = new User(newUser.getId(), newUser.getFirstName(), newUser.getLastName(), newUser.getLogin());
        userRepository.save(user);

    }

    @Override
    public void updateUser(UserCreateDto newUser, Long id) {

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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}