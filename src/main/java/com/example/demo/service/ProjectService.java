package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.Project;
import com.example.demo.model.ProjectDTO;
import com.example.demo.model.PersonDTO;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.repository.AutoProjectMapper;
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
			projectRepo.save(newProject);
			return "success";
		} else {
			return "failure";
		}
		
		

	

	}

	public List<ProjectDTO> getAllProjects() {
		List<Project> projectlist = projectRepo.findAll();
		List<ProjectDTO> projectDTOlist = modelMapper.map(projectlist, new TypeToken<List<ProjectDTO>>() {
		}.getType());
		return projectDTOlist;
	}

	public int deleteProject(Integer pid) {
		Optional<Project> user = projectRepo.findById(pid);
		if (user.isPresent()) {
			projectRepo.deleteById(pid);

			return 1;

		}
		return 0;

	}


	public void unarchieveProject(Integer pid) {

		Optional<Project> projectlist = projectRepo.findById(pid);
		if (projectlist.isPresent()) {
			Project project = projectlist.get();
			project.setArchieve(false);
			projectRepo.save(project);
		}
	}

	public List<ProjectDTO> getLiveProject() {
		List<Project> projectlist = projectRepo.findByArchieve(false);
		List<ProjectDTO> projectDTOlist = modelMapper.map(projectlist, new TypeToken<List<ProjectDTO>>() {
		}.getType());

		return projectDTOlist;

	}

	@Scheduled(cron = "0 0 0 1 * *") // Runs at midnight on the first day of every month
	public void scheduleArchiveOldProjects(Integer pid) {
		archiveOldProjects(pid);
	}

	@SuppressWarnings("unused")
	private void archiveOldProjects(Integer pid) {
		LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
		Optional<Project> projectlist = projectRepo.findById(pid);
		if (projectlist.isPresent()) {
			Project project = projectlist.get();
			project.setArchieve(true);
			projectRepo.save(project);
		}

	}

}
