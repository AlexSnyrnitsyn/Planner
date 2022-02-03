package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserSkillDto;
import com.example.planner.error.EntityNotFoundException;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.model.UserSkill;
import com.example.planner.repository.SkillRepository;
import com.example.planner.repository.UserRepository;
import com.example.planner.repository.UserSkillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSkillServiceImplTest {

    @Autowired
    private UserSkillServiceImpl userSkillService;

    @MockBean
    private UserSkillRepository userSkillRepository;

    @MockBean
    private SkillRepository skillRepository;

    @MockBean
    private UserRepository userRepository;

    @Test(expected = EntityNotFoundException.class)
    public void errorCreateUser() {

        UserSkillDto userSkillDto = TestData.getUserSkill();

        Mockito.doReturn(Optional.empty()).when(userRepository).findById(1L);

        userSkillService.createUserSkill(userSkillDto);

    }

    @Test(expected = EntityNotFoundException.class)
    public void errorCreateSkill() {

        UserSkillDto userSkillDto = TestData.getUserSkill();

        Mockito.doReturn(Optional.of(new User())).when(userRepository).findById(1L);
        Mockito.doReturn(Optional.empty()).when(skillRepository).findById(1L);

        userSkillService.createUserSkill(userSkillDto);
    }

    @Test
    public void CreateUserSkill() {

        UserSkillDto userSkillDto = TestData.getUserSkill();

        Mockito.doReturn(Optional.of(new User())).when(userRepository).findById(1L);
        Mockito.doReturn(Optional.of(new Skill())).when(skillRepository).findById(1L);

        userSkillService.createUserSkill(userSkillDto);

        Mockito.verify(userSkillRepository, Mockito.times(1)).save(any());
    }

    @Test(expected = EntityNotFoundException.class)
    public void errorUpdateUserSkill() {

        UserSkillDto userSkillDto = TestData.getUserSkill();

        Mockito.doReturn(Optional.empty()).when(userSkillRepository).findById(1L);

        userSkillService.updateUserSkill(userSkillDto, 1L);
    }

    @Test
    public void updateUserSkill() {

        UserSkillDto userSkillDto  = TestData.getUserSkill();

        Mockito.doReturn(Optional.of(new UserSkill())).when(userSkillRepository).findById(1L);

        userSkillService.updateUserSkill(userSkillDto, 1L);

        Mockito.verify(userSkillRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void deleteUserSkill() {

        Mockito.doReturn(Optional.empty()).when(userSkillRepository).findById(1L);

        userSkillService.deleteUserSkill(1L);
        Mockito.verify(userSkillRepository, Mockito.times(1)).deleteById(1L);
    }
}


