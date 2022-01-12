package com.example.planner.service;

import com.example.planner.dto.UserDto;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.mapper.UserMapper;
import com.example.planner.model.Position;
import com.example.planner.model.Subdivision;
import com.example.planner.model.User;
import com.example.planner.repository.PositionRepository;
import com.example.planner.repository.SubdivisionRepository;
import com.example.planner.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PositionRepository positionRepository;

    @MockBean
    private SubdivisionRepository subdivisionRepository;

    @Test(expected = EntityNotFoundException.class)
    public void errorPosition(){
        UserDto userDto = new UserDto();

        userDto.setPositionId(1L);
        Mockito.doReturn(Optional.empty()).when(positionRepository).findById(any());

        userService.createUser(userDto);

    }

    @Test(expected = EntityNotFoundException.class)
    public void errorSubdivision(){
        UserDto userDto = new UserDto();

        userDto.setPositionId(1L);
        userDto.setSubdivisionId(1L);

        Mockito.doReturn(Optional.of(new Position())).when(positionRepository).findById(any());
        Mockito.doReturn(Optional.empty()).when(subdivisionRepository).findById(any());

        userService.createUser(userDto);
    }

    @Test
    public void createUser() {
        UserDto userDto = new UserDto();

        userDto.setPositionId(1L);
        userDto.setSubdivisionId(1L);

        Mockito.doReturn(Optional.of(new Position())).when(positionRepository).findById(any());
        Mockito.doReturn(Optional.of(new Subdivision())).when(subdivisionRepository).findById(any());

        userService.createUser(userDto);

        Mockito.verify(userRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void updateUser() {
        UserDto userDto = new UserDto();

        userDto.setFirstName("Alexandr");
        userDto.setLastName("Alexandrov");

        Mockito.doReturn(Optional.of(new User())).when(userRepository).findById(1L);

        userService.updateUser(userDto, 1L);

        Mockito.verify(userRepository, Mockito.times(1)).save(any());

    }

    @Test
    public void deleteUser() {

        userService.deleteUser(1L);
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void errorUserPosition() {

        Mockito.doReturn(Optional.empty()).when(positionRepository).findById(1L);
        userService.updatePosition(1L,1L);

    }

    @Test
    public void updateUserPosition() {
        User user = new User();

        Mockito.doReturn(user).when(userRepository).getById(1L);
        Mockito.doReturn(Optional.of(new Position())).when(positionRepository).findById(1L);

        userService.updatePosition(1L,1L);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);

    }

    @Test(expected = EntityNotFoundException.class)
    public void errorUserSubdivision() {

        Mockito.doReturn(Optional.empty()).when(subdivisionRepository).findById(1L);
        userService.updateSubdivision(1L,1L);
    }

    @Test
    public void updateUserSubdivision() {
        User user = new User();

        Mockito.doReturn(user).when(userRepository).getById(1L);
        Mockito.doReturn(Optional.of(new Subdivision())).when(subdivisionRepository).findById(1L);

        userService.updateSubdivision(1L,1L);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);

    }

    @Test(expected = UsernameNotFoundException.class)
    public void errorLoadUserByUsername() {
        User user = new User();

        user.setLogin("1234");
        Mockito.doReturn(null).when(userRepository).findByLogin("1234");

        userService.loadUserByUsername("1234");

    }

    @Test
    public void LoadUserByUsername() {
        User user = new User();

        user.setLogin("1234");

        Mockito.doReturn(user).when(userRepository).findByLogin("1234");
        userService.loadUserByUsername("1234");

        Mockito.verify(userRepository, Mockito.times(1)).findByLogin(any());
    }

}