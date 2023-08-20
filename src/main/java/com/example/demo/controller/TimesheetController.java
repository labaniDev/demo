package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TimesheetDTO;
import com.example.demo.service.TimesheetService;

@RestController
@RequestMapping("/api/work")
@CrossOrigin(origins = "*")
public class TimesheetController {

	@Autowired
	TimesheetService timeService;

	@PostMapping("/startwork")
	public ResponseEntity<Boolean> startWork(@RequestBody TimesheetDTO timesheetDTO) {

		timeService.saveStartTime(timesheetDTO);

		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
	
	}
	@PostMapping("/endwork")
	public ResponseEntity<Boolean> endWork(@RequestBody TimesheetDTO timesheetDTO) {
		timeService.saveEndTime(timesheetDTO);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
		
	}
//	@PostMapping("/duration")
//	public ResponseEntity getDuration(@RequestBody WorkDTO workDto){
//		workService.getTimeDuration();
//		return new ResponseEntity(HttpStatus.OK);
//	}
//	
  
	@GetMapping("/gettime")
	public ResponseEntity<Long> getCurrentTime(@RequestBody TimesheetDTO timesheetDTO) {
		Long duration=timeService.getCurrentTime(timesheetDTO);
		return new ResponseEntity<Long>(duration,HttpStatus.OK);
}

	
	
//	public ResponseEntity<List<WorkDTO>> getFreelancerMonthlySalary(@RequestParam("userid") Integer userid,@RequestParam("pid") Integer pid){
//		List<WorkDTO> salaries=workService.getMonthlySalary(pid, userid);
//		if(salaries.isEmpty()) {
//			return (ResponseEntity<List<WorkDTO>>) ResponseEntity.noContent();
//		}
//		return ResponseEntity.ok(salaries);
//	}
}