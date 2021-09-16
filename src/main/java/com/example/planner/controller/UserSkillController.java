package com.example.planner.controller;

import com.example.planner.dto.UserDto;
import com.example.planner.dto.UserSkillDto;
import com.example.planner.error.ServiceException;
import com.example.planner.model.User;
import com.example.planner.model.UserSkill;
import com.example.planner.service.UserService;
//import com.example.planner.service.UserSkillService;
import com.example.planner.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userSkill")
public class UserSkillController {

    @Autowired
    private UserSkillService userSkillService;

    @PostMapping
    public ResponseEntity<UserSkillDto> createUser(@RequestBody UserSkillDto userSkillDto) throws ServiceException {

        userSkillService.createUserSkill(userSkillDto);
        return ResponseEntity.ok(userSkillDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserSkillDto> updateSkillUser(@RequestBody UserSkillDto userSkillDto, @PathVariable Long id) throws ServiceException{

        userSkillService.updateUserSkill(userSkillDto, id);
        return ResponseEntity.ok(userSkillDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserSkill> deleteUser(@PathVariable Long id){

        UserSkill userSkill = userSkillService.getUserSkillById(id);

        userSkillService.deleteUserSkill(id);
        return ResponseEntity.ok(userSkill);
    }

}
