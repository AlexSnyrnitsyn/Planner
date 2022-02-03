package com.example.planner.service;


import com.example.planner.dto.ProjectDto;
import com.example.planner.dto.UserDto;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.model.Position;
import com.example.planner.model.Project;
import com.example.planner.model.Subdivision;
import com.example.planner.model.User;
import com.example.planner.repository.ProjectRepository;
import com.example.planner.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    private ProjectServiceImpl projectService;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void creatProject() {
        ProjectDto projectDto = new ProjectDto();

        projectService.createProject(projectDto);

        Mockito.verify(projectRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void updateProject() {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setProjectName("Test");
        projectDto.setComplexityProject("Test");
        projectDto.setGoalProject("Test");

        Mockito.doReturn(Optional.of(new Project())).when(projectRepository).findById(1L);

        projectService.updateProject(projectDto, 1L);

        Mockito.verify(projectRepository, Mockito.times(1)).save(any());

    }

    @Test
    public void deleteUser() {

        projectService.deleteProject(1L);
        Mockito.verify(projectRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void errorProject(){

        Mockito.doReturn(Optional.empty()).when(projectRepository).findById(any());

        projectService.addUserToProject(1L, 1L);

    }

    @Test(expected = EntityNotFoundException.class)
    public void errorUserToProject(){

        Mockito.doReturn(Optional.of(new Project())).when(projectRepository).findById(1L);
        Mockito.doReturn(Optional.empty()).when(userRepository).findById(1L);

        projectService.addUserToProject(1L, 1L);

    }

//    @Test
//    public void addUserFromProject(){
//        Project project = new Project();
//        User user = new User();
//        Set <User> users = new HashSet<>();
//        users.add(user);
//        project.setUsers(users);
//
//        Mockito.doReturn(Optional.of(project)).when(projectRepository).findById(1L);
//        Mockito.doReturn(Optional.of(user)).when(userRepository).findById(1L);
//
//        projectService.addUserToProject(1L, 1L);
//
//        Mockito.verify(projectRepository, Mockito.times(1)).save(project);
//    }


    @Test(expected = EntityNotFoundException.class)
    public void errorDeleteProject(){

        Mockito.doReturn(Optional.empty()).when(projectRepository).findById(any());

        projectService.deleteUserToProject(1L, 1L);

    }

    @Test(expected = EntityNotFoundException.class)
    public void errorDeleteUserToProject(){

        Mockito.doReturn(Optional.of(new Project())).when(projectRepository).findById(1L);
        Mockito.doReturn(Optional.empty()).when(userRepository).findById(1L);

        projectService.deleteUserToProject(1L, 1L);

    }

    @Test
    public void deleteUserFromProject(){
        Project project = new Project();
        User user = new User();
        Set <User> users = new HashSet<>();
        users.add(user);
        project.setUsers(users);

        Mockito.doReturn(Optional.of(project)).when(projectRepository).findById(1L);
        Mockito.doReturn(Optional.of(user)).when(userRepository).findById(1L);

        projectService.deleteUserToProject(1L, 1L);

        Mockito.verify(projectRepository, Mockito.times(1)).save(project);
    }
    
}
