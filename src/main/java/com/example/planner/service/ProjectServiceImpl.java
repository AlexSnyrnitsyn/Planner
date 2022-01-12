package com.example.planner.service;

import com.example.planner.dto.ProjectDto;
import com.example.planner.dto.UserDto;
import com.example.planner.enums.ResponseCode;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.mapper.ProjectMapper;
import com.example.planner.mapper.UserMapper;
import com.example.planner.model.Project;
import com.example.planner.model.User;
import com.example.planner.repository.ProjectRepository;
import com.example.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;


    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;

    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return ProjectMapper.INSTANCE.allProjectsToProjectDto(projectRepository.findAll());
    }

    @Override
    public void createProject(ProjectDto newProject) {

        Project project = ProjectMapper.INSTANCE.projectDtoToProject(newProject);

        projectRepository.save(project);
    }

    @Override
    public void updateProject(ProjectDto newProject, Long id) {

        projectRepository.findById(id).map(project -> {
            project.setProjectName(newProject.getProjectName());
            project.setComplexityProject(newProject.getComplexityProject());
            project.setGoalProject(newProject.getGoalProject());
            return projectRepository.save(project);
        });
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void addUserToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException(ResponseCode.PROJECT_NOT_FOUND));

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(ResponseCode.USER_NOT_FOUND));

        Set<User> users = project.getUsers();
        users.add(user);
        project.setUsers(users);
        projectRepository.save(project);
    }

    @Override
    public void deleteUserToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException(ResponseCode.PROJECT_NOT_FOUND));

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(ResponseCode.USER_NOT_FOUND));

        Set<User> users = project.getUsers();
        users.remove(user);
        project.setUsers(users);
        projectRepository.save(project);
    }

    @Override
    public Set<UserDto> getUsersToProject(Long projectId) {

        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException(ResponseCode.PROJECT_NOT_FOUND));

        return UserMapper.INSTANCE.allUsersToSetUserDto(project.getUsers());
    }
}
