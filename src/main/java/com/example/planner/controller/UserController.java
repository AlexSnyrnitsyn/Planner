package com.example.planner.controller;

import com.example.planner.dto.UserDto;
import com.example.planner.enums.ResponseCode;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.model.User;
import com.example.planner.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "Получить всех пользователей")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    @ApiOperation(value = "Добавить пользователя")
    public ResponseEntity<UserDto> creatUser(@ApiParam("user") @RequestBody UserDto user) {

        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Изменить пользователя")
    public ResponseEntity<UserDto> updateUser(@ApiParam("user") @RequestBody UserDto user,
                                              @ApiParam("userId") @PathVariable Long id) {

        userService.updateUser(user, id);
        userService.updatePosition(id, user.getPositionId());
        userService.updateSubdivision(id, user.getSubdivisionId());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить пользователя")
    public void deleteUser(@ApiParam("userId") @PathVariable Long id){

        userService.deleteUser(id);
    }
}
