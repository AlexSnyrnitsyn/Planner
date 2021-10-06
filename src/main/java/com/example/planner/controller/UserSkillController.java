package com.example.planner.controller;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserSkillDto;
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

    @GetMapping
    public ResponseEntity<List<UserSkillDto>> getAllUsers(){

        List<UserSkillDto> userSkills = userSkillService.getAllUserSkill();

        return ResponseEntity.ok(userSkills);
    }

    @PostMapping
    public ResponseEntity<UserSkillDto> createUser(@RequestBody UserSkillDto userSkillDto) {

        userSkillService.createUserSkill(userSkillDto);
        return ResponseEntity.ok(userSkillDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserSkillDto> updateSkillUser(@RequestBody UserSkillDto userSkillDto, @PathVariable Long id) {

        userSkillService.updateUserSkill(userSkillDto, id);
        return ResponseEntity.ok(userSkillDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity.BodyBuilder deleteSkillUser(@PathVariable Long id){

        userSkillService.deleteUserSkill(id);
        return ResponseEntity.ok();
    }

}
