package com.example.planner.controller;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.service.SkillService;
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
@RequestMapping("/skill")
@Api(value = "SkillController")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    @ApiOperation(value = "Получить все навыки")
    public ResponseEntity<List<SkillDto>> getAllUsers(){

        List<SkillDto> skills = skillService.getAllSkill();

        return ResponseEntity.ok(skills);
    }

    @PostMapping
    @ApiOperation(value = "Создать навык")
    public ResponseEntity<SkillDto> creatSkill(@ApiParam("skill") @RequestBody SkillDto skill){

        skillService.createSkill(skill);
        return ResponseEntity.ok(skill);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Изменить навык")
    public void updateSkill(@ApiParam("skill") @RequestBody SkillDto skill, @ApiParam("skillId") @PathVariable Long id){

        skillService.updateSkill(skill, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить навык")
    public void deleteSkill(@ApiParam("skillId") @PathVariable Long id){

        skillService.deleteSkill(id);
    }
}
