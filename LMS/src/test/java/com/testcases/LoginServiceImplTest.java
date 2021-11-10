package com.testcases;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.*;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

import com.entites.Login;
import com.repository.LoginRepository;
import com.service.LoginServ;
	@SpringBootTest
	class LoginServiceImplTest {
		@Autowired
		LoginServ loginservice;
		@MockBean
		LoginRepository loginrepo;
		@Test
		void testAddLoginDetails() {
			Login l1=new Login();
			l1.setLoginId(1);
			l1.setUserName("Sahithi");
			l1.setPassword("sahi@01");
			Mockito.when(loginrepo.save(l1)).thenReturn(l1);
			assertThat(loginservice.addLoginDetails(l1)).isEqualTo(l1);
			
		}

		@Test
		void testUpdateLoginDetails() throws Throwable {
			Login l1=new Login();
			l1.setLoginId(1);
			l1.setUserName("Sahithi");
			l1.setPassword("sahi@01");
			Optional<Login> l2=Optional.of(l1);
			Mockito.when(loginrepo.findById(1)).thenReturn(l2);
			Mockito.when(loginrepo.save(l1)).thenReturn(l1);
			l1.setLoginId(1);
			l1.setUserName("Sai");
			l1.setPassword("sai@01");
			assertThat(loginservice.updateLoginDetails(l1)).isEqualTo(l1);
		}

		@Test
		void testDeleteLoginDetails() {
			Login l1=new Login();
			l1.setLoginId(1);
			l1.setUserName("Sahithi");
			l1.setPassword("sahi@01");
			Optional<Login> l2=Optional.of(l1);
			Mockito.when(loginrepo.findById(1)).thenReturn(l2);
			Mockito.when(loginrepo.existsById(l1.getLoginId())).thenReturn(false);
			assertFalse(loginrepo.existsById(l1.getLoginId()));
		}

		@Test
		void testViewloginList() {
			Login l1=new Login();
			l1.setLoginId(1);
			l1.setUserName("Sahithi");
			l1.setPassword("sahi@01");
			
			Login l2=new Login();
			l2.setLoginId(2);
			l2.setUserName("Sai");
			l2.setPassword("sai@01");
			
			List<Login> loginlist=new ArrayList<Login>();
			loginlist.add(l1);
			loginlist.add(l2);
			
			Mockito.when(loginrepo.findAll()).thenReturn(loginlist);
			assertThat(loginservice.viewloginList()).isEqualTo(loginlist);
		}

		@Test
		void testViewusersbyid() throws Throwable {
			Login l1=new Login();
			l1.setLoginId(1);
			l1.setUserName("Sahithi");
			l1.setPassword("sahi@01");
			Optional<Login> l2=Optional.of(l1);
			Mockito.when(loginrepo.findById(1)).thenReturn(l2);
			assertThat(loginservice.viewusersbyid(1)).isEqualTo(l1);
		}

		/*  @Test 
		  void testGetuserByName() 
		  { 
			  Login l1=new Login();
				l1.setLoginId(1);
				l1.setUserName("Sahithi");
				l1.setPassword("sahi@01");
				Mockito.when(loginrepo.findByusername("Sahithi")).thenReturn(l1);
				assertThat(loginservice.getuserByName("Sahithi")).isEqualTo(l1);
		  }*/
		 
	}


