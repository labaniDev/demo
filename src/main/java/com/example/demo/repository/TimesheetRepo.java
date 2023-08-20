package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;
import com.example.demo.entity.Timesheet;
import com.example.demo.projections.TimesheetProjectionDTO;

@Repository
public interface TimesheetRepo extends JpaRepository<Timesheet, Integer>, CrudRepository<Timesheet, Integer> {
	
	Timesheet findByPersonAndCid(Person p, @Param("cid")Integer cid);
	
	
	
	Timesheet findByPerson(Person p);
	
	
	@Query(value="SELECT p.userid as userid ,pr.pid as pid,pr.projectname as projectname ,t.duration as duration ,p.hourlyrate as hourlyrate "+"FROM Timesheet t "+"JOIN Person p ON p.userid=t.userid "+" JOIN project pr ON t.pid = pr.pid "+"WHERE  p.userid  =:userid AND pr.pid = :pid ",nativeQuery=true)
	List<TimesheetProjectionDTO> getMonthlySalary(@Param("userid") Integer userid,@Param("pid") Integer pid);





	
}
