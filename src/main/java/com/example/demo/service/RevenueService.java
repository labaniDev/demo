package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Revenue;
import com.example.demo.model.RevenueDTO;
import com.example.demo.projections.TimesheetProjectionDTO;
import com.example.demo.repository.RevenueRepo;
import com.example.demo.repository.TimesheetRepo;
@Service
public class RevenueService {
	@Autowired
	TimesheetRepo timeRepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	RevenueRepo revenueRepo;
	
	
	
	public double getTotalSalary(Integer userid,Integer pid) {
		
		
		List<TimesheetProjectionDTO> projectlist=timeRepo.getMonthlySalary(userid, pid);
		double totalincome = 0.0;
		if(projectlist!=null) {
			
			for (TimesheetProjectionDTO dto: projectlist) {
				double hourlyrate=dto.getHourlyrate();
				double duration=dto.getDuration();
				
				double projectIncome = hourlyrate * duration / 3600;
				totalincome+=projectIncome;
				
			}
			
			
		}
		return totalincome;
	}
	
	
	public void saveuser(RevenueDTO r) {
		Revenue user=modelMapper.map(r, Revenue.class);
		user=revenueRepo.save(user);
	}
}
