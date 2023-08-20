package com.example.demo.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Calender;
import com.example.demo.entity.Person;
import com.example.demo.entity.Timesheet;
import com.example.demo.model.TimesheetDTO;
import com.example.demo.repository.CalenderRepo;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.TimesheetRepo;

@Service
public class TimesheetService {

	@Autowired
	DeveloperRepo developerRepo;

	@Autowired
	CalenderRepo calenderRepo;

	@Autowired
	TimesheetRepo timeRepo;

	public void saveStartTime(TimesheetDTO timesheetDTO) {

		if (timesheetDTO.getUserid() != null && developerRepo.findById(timesheetDTO.getUserid()) != null) {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzzz yyyy");
			LocalDateTime startdateTime = LocalDateTime.parse(timesheetDTO.getStartTime(), format);

			LocalTime localTime = startdateTime.toLocalTime();

			java.sql.Time start_time = java.sql.Time.valueOf(localTime);

			Timesheet work = new Timesheet();

			Calender calender = calenderRepo.findByDayAndMonthAndYear(startdateTime.getDayOfMonth(),
					startdateTime.getMonth().getValue(), startdateTime.getYear());

			work.setCid(calender.getCid());
			work.setStarttime(start_time);
			
			Optional<Person> p=developerRepo.findById(timesheetDTO.getUserid());
			
			if(p.isPresent()) {
				work.setPerson(p.get());
			}
			
			//work.setUserid(workDTO.getUserid());

			timeRepo.save(work);

		}
	}

	@SuppressWarnings("unused")
	public void saveEndTime(TimesheetDTO timesheetDTO) {
		long duration = 0L;

		DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzzz yyyy");
		LocalDateTime enddateTime = LocalDateTime.parse(timesheetDTO.getEndtime(), format);
		LocalTime localTime = enddateTime.toLocalTime();
		java.sql.Time end_time = java.sql.Time.valueOf(localTime);

		Calender calender = calenderRepo.findByDayAndMonthAndYear(enddateTime.getDayOfMonth(),
				enddateTime.getMonth().getValue(), enddateTime.getYear());

//				//if(workDTO.getUserId().equals(calender.getCid()) && calender.getCid().equals(workDTO.getTid())) {
		
		Optional<Person> p =developerRepo.findById(timesheetDTO.getUserid());

		Timesheet work = timeRepo.findByPersonAndCid(p.get(), calender.getCid());
		if (work != null) {

			work.setEndtime(end_time);
			Duration duration1 = Duration.between(work.getStarttime().toLocalTime(), end_time.toLocalTime());
			work.setDuration(duration1.getSeconds());
			
			
          timeRepo.save(work);
		}

	}

	@SuppressWarnings("unused")
	public long getCurrentTime(TimesheetDTO timesheetDTO) {
		long period = 0L;
		LocalTime currenttime = LocalTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(" HH:mm:ss");
		Optional<Person> p =developerRepo.findById(timesheetDTO.getUserid());
		Timesheet work = timeRepo.findByPerson(p.get());
		
		period = Duration.between(work.getStarttime().toLocalTime(), currenttime).getSeconds();
		return period;

	}
	
}
