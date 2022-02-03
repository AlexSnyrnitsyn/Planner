package com.example.planner.mapper;

import com.example.planner.dto.ProjectDto;
import com.example.planner.dto.UserDto;
import com.example.planner.model.Project;
import com.example.planner.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project projectDtoToProject(ProjectDto projectDto);

    List<ProjectDto> allProjectsToProjectDto(List<Project> projects);
}
