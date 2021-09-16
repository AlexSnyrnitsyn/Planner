package com.example.planner.controller;

import com.example.planner.dto.UserDto;
import com.example.planner.error.ServiceException;
import com.example.planner.model.Position;
import com.example.planner.model.Subdivision;
import com.example.planner.model.User;
import com.example.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDto> creatUser(@RequestBody UserDto user) throws ServiceException {

        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable Long id) throws ServiceException{

        userService.updateUser(user, id);
        userService.updatePosition(id, user.getPositionId());
        userService.updateSubdivision(id, user.getSubdivisionId());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User user = userService.getById(id);

        userService.deleteUser(id);
        return ResponseEntity.ok(user);
    }
}
