//package com.example.demo.repository;
//
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;

//
//
//
//
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class TimesheetRepoTest {
//	
//	@Autowired
//	TimesheetRepo wrepo;
//	
//	
//	
//
////	@Test
////	public void givenWorkRepoNotNullTests() {
////		int userId=5;
////		
////		List<WorkProjectionDTO> workList=wrepo.getMonthlySalary(userId);
////		
////		Assertions.assertNotNull(workList);
////		
////		
////	}
//	
////	@Test
////	public void givenWorkRepoValueTests() {
////		int userId=5;
////		
////		List<WorkProjectionDTO> workList=wrepo.getMonthlySalary(userId);
////		
////		WorkProjectionDTO dto =workList.get(0);
////		
////		
////		Assertions.assertEquals(
////			    5,
////			    dto.getUserid()
////			);
////	}
////	@Test
////	public void givenWorkRepoValueTests1() {
////		
////		int pid=5;
////		List<WorkProjectionDTO> workList=wrepo.getMonthlySalary(pid, pid);
////		WorkProjectionDTO dto=workList.get(0);
////		Assertions.assertEquals(5, dto.getUserid());
////		
//	}
////	@TEST
////	PUBLIC VOID GIVENWORKREPONOTNULLTESTS1() {
////		INT USERID=5;
////		INT CID=0;
////		
////		WORK WORK=WREPO.FINDBYUSERIDANDCID(USERID, CID);
////		ASSERTIONS.ASSERTNOTNULL(WORK);
////	}
//
//
