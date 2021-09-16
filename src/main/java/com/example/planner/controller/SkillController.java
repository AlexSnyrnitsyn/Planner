package com.example.planner.controller;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.service.SkillService;
import com.example.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    public ResponseEntity<SkillDto> creatSkill(@RequestBody SkillDto skill){

        skillService.addSkill(skill);
        return ResponseEntity.ok(skill);
    }

    @PutMapping("{id}")
    public ResponseEntity<SkillDto> updateSkill(@RequestBody SkillDto skill, @PathVariable Long id){

        skillService.updateSkill(skill, id);
        return ResponseEntity.ok(skill);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Skill> deleteUser(@PathVariable Long id){
        Skill skill = skillService.getSkillById(id);

        skillService.deleteSkill(id);
        return ResponseEntity.ok(skill);
    }


}
