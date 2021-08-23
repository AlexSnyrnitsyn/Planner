package com.example.planner.controller;

import com.example.planner.dto.UserCreateDto;
import com.example.planner.model.User;
import com.example.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = this.userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCreateDto> creatUser(@RequestBody UserCreateDto user){

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<UserCreateDto> creatUser(@RequestBody UserCreateDto newUser, @PathVariable Long id){

        if(newUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.userService.updateUser(newUser, id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserCreateDto> deleteUser(@PathVariable Long id){
//        User user = this.userService.getById(id);

//        if(user == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }
