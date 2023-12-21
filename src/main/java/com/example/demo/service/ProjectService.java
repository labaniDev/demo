package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.Project;
import com.example.demo.model.ProjectDTO;
import com.example.demo.model.PersonDTO;
import com.example.demo.repository.ProjectRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.repository.CacheDataRepo;
import com.example.demo.repository.DeveloperRepo;

@Service
public class ProjectService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	ProjectRepo projectRepo;
	@Autowired
	DeveloperRepo developerRepo;
	@Autowired
	PersonDTO person;
	@Autowired
	CacheDataRepo cacheDataRepo;
	@Autowired
	ObjectMapper objectMapper;
	/*
	 * @Autowired AutoProjectMapper autoProjectMapper;
	 */
	
	
	public void createProject(ProjectDTO projectDTO) {
		
		Optional<Person> userOptional = developerRepo.findById(projectDTO.getUserid());
		if (userOptional.isPresent()) {
			Person user = userOptional.get();
			Project project = new Project();
			project.setProjectname(projectDTO.getProjectname());
			project.setProjectdescription(projectDTO.getProjectdescription());
			project.getPersons().add(user);
			
			
//			if(project.getStatus()!=null) {
//				project.setStatus(projectDTO.getStatus());
//			}

			//Project create = modelMapper.map(admin, Project.class);
			@SuppressWarnings("unused")
			Project createdProject = projectRepo.save(project);
		}
	}

	public String updateProject (Integer pid,ProjectDTO projectDTO) {
		Optional<Project> project = projectRepo.findById(projectDTO.getPid());
		if (project.isPresent()) {
			Project newProject=project.get();
			newProject.setProjectname(projectDTO.getProjectname());
			newProject.setProjectdescription(projectDTO.getProjectdescription());
			newProject.setStatus(projectDTO.getStatus());
			projectRepo.save(newProject);
			return "success";
		} else {
			return "failure";
		}

	}
	
	
	  public String updateStatus(Integer pid,ProjectDTO projectDTO) {
	  Optional<Project> projectOptional=projectRepo.findById(projectDTO.getPid());
	  
	  if(projectOptional.isPresent()) { 
		  Project newProject=projectOptional.get();
	  newProject.setStatus(projectDTO.getStatus());
	  projectRepo.save(newProject);
	  return "success";
	  } return "failure"; }
	 

	//public List<ProjectDTO> getAllProjects() {//throws InterruptedException, JsonProcessingException {
//		Optional<CacheData> OptionalCacheData=cacheDataRepo.findById("allprojects");
//		
//		if(OptionalCacheData.isPresent()) {
//			String projectAsString = OptionalCacheData.get().getValue();
//			TypeReference<List<ProjectDTO>> mapType = new TypeReference<List<ProjectDTO>>() {};
//            List<ProjectDTO> projectList = objectMapper.readValue(projectAsString, mapType);
//		}
//		
//		List<Project> projectlist=projectRepo.findAll();
//		String productsAsJsonString = objectMapper.writeValueAsString(projectlist);
		
		
		
//		List<Project> projectlist = projectRepo.findByArchiveFalse();
//		List<ProjectDTO> projectDTOlist = modelMapper.map(projectlist, new TypeToken<List<ProjectDTO>>() {
//		}.getType());
//		
//		
//		return projectDTOlist;
//	}

	public int deleteProject(Integer pid) {
		Optional<Project> user = projectRepo.findById(pid);
		if (user.isPresent()) {
			projectRepo.deleteById(pid);

			return 1;

		}
		return 0;

	}


	

//	public List<ProjectDTO> getArchiveProjects() {
//		List<Project> projectlist =projectRepo.findByArchiveTrue();
//		List<ProjectDTO> projectDTOlist = modelMapper.map(projectlist, new TypeToken<List<ProjectDTO>>() {
//		}.getType());
//
//		return projectDTOlist;
//
//	}

//	@Scheduled(cron = "0 0 0 1 * *") // Runs at midnight on the first day of every month
//	public void scheduleArchiveOldProjects(Integer pid) {
//		archiveOldProjects(pid);
//	}

	
//	public void archiveOldProjects(Integer pid) {
//		Optional<Project> projectlist = projectRepo.findById(pid);
//		if (projectlist.isPresent()) {
//			Project project = projectlist.get();
//			project.setArchive(true);
//			projectRepo.save(project);
//		}
		
		
		

	}


