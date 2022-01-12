package com.example.planner.controller;

import com.example.planner.dto.ProjectDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Project;
import com.example.planner.model.User;
import com.example.planner.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/project")
@Api(value = "ProjectController")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    @ApiOperation(value = "Получить все проекты")
    public ResponseEntity<List<ProjectDto>> getAllProjects(){

        List<ProjectDto> projects = projectService.getAllProjects();

        return ResponseEntity.ok(projects);
    }

    @PostMapping
    @ApiOperation(value = "Добавить проект")
    public ResponseEntity<ProjectDto> creatProjects(@ApiParam("project") @RequestBody ProjectDto project) {

        projectService.createProject(project);
        return ResponseEntity.ok(project);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Изменить проект")
    public ResponseEntity<ProjectDto> updateProjects(@ApiParam("project") @RequestBody ProjectDto project,
                                              @ApiParam("projectId") @PathVariable Long id) {

        projectService.updateProject(project, id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить проект")
    public void deleteProjects(@ApiParam("projectId") @PathVariable Long id){

        projectService.deleteProject(id);
    }

    @PostMapping("/addUser/{projectId}")
    @ApiOperation(value = "Добавить пользователя в проект")
    public ResponseEntity addUserToProjects(@RequestBody UserDto userDto,
                                                     @PathVariable Long projectId) {

        projectService.addUserToProject(projectId, userDto.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteUser/{projectId}")
    @ApiOperation(value = "Удалить пользователя из проекта")
    public ResponseEntity deleteUserFromProject(@RequestBody UserDto userDto,
                                            @PathVariable Long projectId) {

        projectService.deleteUserToProject(projectId, userDto.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{projectId}/users")
    @ApiOperation(value = "Получить всех юзеров, которые работаю над проектом")
    public ResponseEntity<Set<UserDto>> getUsersToProject(@PathVariable Long projectId){

        Set <UserDto> users = projectService.getUsersToProject(projectId);

        return ResponseEntity.ok(users);
    }

}
