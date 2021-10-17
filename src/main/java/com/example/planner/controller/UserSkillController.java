package com.example.planner.controller;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserSkillDto;
//import com.example.planner.service.UserSkillService;
import com.example.planner.service.UserSkillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userSkill")
@Api(value = "UserSkillController")
public class UserSkillController {

    @Autowired
    private UserSkillService userSkillService;

    @GetMapping
    @ApiOperation(value = "Получить все связки")
    public ResponseEntity<List<UserSkillDto>> getAllUsers(){

        List<UserSkillDto> userSkills = userSkillService.getAllUserSkill();

        return ResponseEntity.ok(userSkills);
    }

    @PostMapping
    @ApiOperation(value = "Создать связку")
    public ResponseEntity<UserSkillDto> createUser(@ApiParam("userSkill") @RequestBody UserSkillDto userSkillDto) {

        userSkillService.createUserSkill(userSkillDto);
        return ResponseEntity.ok(userSkillDto);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Изменить связку")
    public ResponseEntity<UserSkillDto> updateSkillUser(@ApiParam("userSkill") @RequestBody UserSkillDto userSkillDto,
                                                        @ApiParam("userSkillId") @PathVariable Long id) {

        userSkillService.updateUserSkill(userSkillDto, id);
        return ResponseEntity.ok(userSkillDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить связку")
    public void deleteSkillUser(@ApiParam("userSkillId") @PathVariable Long id){

        userSkillService.deleteUserSkill(id);
    }

}
