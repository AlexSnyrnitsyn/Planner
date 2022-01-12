package com.example.planner.service;

import com.example.planner.dto.SkillDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Skill;
import com.example.planner.model.User;
import com.example.planner.repository.SkillRepository;
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
public class SkillServiceImplTest {

    @Autowired
    private SkillServiceImpl skillService;

    @MockBean
    private SkillRepository skillRepository;

    @Test
    public void createSkill() {

        SkillDto skillDto = new SkillDto();

        skillService.createSkill(skillDto);

        Mockito.verify(skillRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void deleteSkill() {

        Mockito.doReturn(Optional.empty()).when(skillRepository).findById(1L);

        skillService.deleteSkill(1L);
        Mockito.verify(skillRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void updateSkill() {
        SkillDto skillDto = new SkillDto();

        skillDto.setDescription("C++ lang");
        skillDto.setSkillName("C++");

        Mockito.doReturn(Optional.of(new Skill())).when(skillRepository).findById(1L);

        skillService.updateSkill(skillDto, 1L);

        Mockito.verify(skillRepository, Mockito.times(1)).save(any());
    }
}