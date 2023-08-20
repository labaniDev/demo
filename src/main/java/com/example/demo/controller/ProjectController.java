package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProjectDTO;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*")
public class ProjectController {
	@Autowired
 ProjectService projectService;
	
	@PostMapping("/createProject")
	public ResponseEntity<Object> createProject(@RequestBody ProjectDTO project) {

		projectService.createProject(project);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	@PutMapping("/editProject")	
	public ResponseEntity<String> updateProject(@RequestBody ProjectDTO project){
		projectService.updateProject(project);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	@GetMapping("/viewProject")
	public List<ProjectDTO> viewAllProjects(){
		return projectService.getAllProjects();
	}
	@DeleteMapping("/deleteProject/{pid}")
	public String deleteProject(@PathVariable("pid") Integer pid) {
		projectService.deleteProject(pid);
		return "Project Successfully Deleted";
	}
	@PostMapping("/archieveProject/{pid}")
	public ResponseEntity<String> archieveProject(@PathVariable("pid") Integer pid) {
		projectService.scheduleArchiveOldProjects(pid);
		return  ResponseEntity.ok("Project Archieved Successfully");
	}
	@PostMapping("/unarchieveProject/{pid}")
	public ResponseEntity<String> unarchieveProject(@PathVariable("pid") Integer pid) {
		projectService.unarchieveProject(pid);
		return ResponseEntity.ok("Project Unarchieve successfully");
	}
	@GetMapping("/activeProject")
	public ResponseEntity<List<ProjectDTO>> getAllLiveProject() {
		List<ProjectDTO> liveprojectlist=projectService.getLiveProject();
		return ResponseEntity.ok(liveprojectlist);
	}
	  
	
	
}
