package com.example.planner.service;

import com.example.planner.dto.ProjectDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Project;
import com.example.planner.model.User;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    List<ProjectDto> getAllProjects();

    void createProject(ProjectDto project);

    void updateProject(ProjectDto project, Long id);

    void deleteProject(Long id);

    void addUserToProject(Long projectId, Long userId);

    void deleteUserToProject(Long projectId, Long userId);

     Set <UserDto> getUsersToProject(Long projectId);

}
