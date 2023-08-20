//package com.example.demo.entity;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.example.demo.repository.RoleRepo;
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class RoleRepositoryTests {
//	@Autowired
//	RoleRepo roleRepo;
//	
//	@Test
//	public void testCreateRoles() {
//		Role admin=new Role("Admin");
//		Role user=new Role("User");
//		
//		roleRepo.saveAll(List.of(admin, user));
//		List<Role> listRoles=(List<Role>) roleRepo.findAll();
//		assertThat(saveUser.);
//	}
//
//}
