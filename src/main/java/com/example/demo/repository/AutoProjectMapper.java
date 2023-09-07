package com.example.demo.repository;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.Project;
import com.example.demo.model.ProjectDTO;

@Mapper(componentModel = "spring")
public interface AutoProjectMapper {
	AutoProjectMapper Mapper=Mappers.getMapper(AutoProjectMapper.class);
	
	ProjectDTO mapToProjectDto(Project project);
	Project mapToProject(ProjectDTO ProjectDTO);
}
