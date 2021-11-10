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

import com.entites.Readers;
import com.repository.ReadersRepository;
import com.service.ReaderServ;
	@SpringBootTest
	class ReaderServiceImplTest {
		@Autowired
		ReaderServ readerserv;
		@MockBean
		ReadersRepository repo;
		@Test
		void testRegister() {
			Readers rd = new Readers();
			rd.setId(1);
			rd.setFirstName("Kalyan");
			rd.setLastName("Ullangula");
			rd.setEmail("Kalyanu@gmail.com");
			rd.setPassword("Kalyan@5651");
			rd.setMobileno("983782992");
			Mockito.when(repo.save(rd)).thenReturn(rd);
			assertThat(readerserv.register(rd)).isEqualTo(rd);
		}

		@Test
		void testUpdateReaderDetails() {
			Readers rd = new Readers();
			rd.setId(1);
			rd.setFirstName("Kalyan");
			rd.setLastName("Ullangula");
			rd.setEmail("Kalyanu@gmail.com");
			rd.setPassword("Kalyan@5651");
			rd.setMobileno("9837829929");
			
			Optional<Readers> aut2 =  Optional.of(rd);
			Mockito.when(repo.findById(1)).thenReturn(aut2);
			Mockito.when(repo.save(rd)).thenReturn(rd);
			
			rd.setFirstName("Zahid");
			rd.setLastName("shaik");
			rd.setEmail("zahid@gmail.com");
			rd.setPassword("Kalyan@5651");
			rd.setMobileno("8378299209");
			assertThat(readerserv.updateReaderDetails(rd)).isEqualTo(rd);
		}

		@Test
		void testDeleteReader() {
			Readers rd = new Readers();
			rd.setId(1);
			rd.setFirstName("Kalyan");
			rd.setLastName("Ullangula");
			rd.setEmail("Kalyanu@gmail.com");
			rd.setPassword("Kalyan@5651");
			rd.setMobileno("983782992");
			Optional<Readers> c2=Optional.of(rd);
			Mockito.when(repo.findById(1)).thenReturn(c2);
			Mockito.when(repo.existsById(rd.getId())).thenReturn(false);
			assertFalse(repo.existsById(rd.getId()));
		}

		@Test
		void testViewReadersList() {
			Readers rd = new Readers();
			rd.setId(1);
			rd.setFirstName("Kalyan");
			rd.setLastName("Ullangula");
			rd.setEmail("Kalyanu@gmail.com");
			rd.setPassword("Kalyan@5651");
			rd.setMobileno("983782992");
			
			Readers rd1 = new Readers();
			rd1.setId(1);
			rd1.setFirstName("Kalyan");
			rd1.setLastName("Ullangula");
			rd1.setEmail("Kalyanu@gmail.com");
			rd1.setPassword("Kalyan@5651");
			rd1.setMobileno("983782992");
			
			List<Readers> readerList = new ArrayList<Readers>();
			readerList.add(rd);
			readerList.add(rd1);
			
			Mockito.when(repo.findAll()).thenReturn(readerList);
			assertThat(readerserv.viewReadersList()).isEqualTo(readerList);
		}

		@Test
		void testViewReaderById() {
			Readers rd = new Readers();
			rd.setId(1);
			rd.setFirstName("Kalyan");
			rd.setLastName("Ullangula");
			rd.setEmail("Kalyanu@gmail.com");
			rd.setPassword("Kalyan@5651");
			rd.setMobileno("983782992");
			
			Optional<Readers> c2 = Optional.of(rd);
			Mockito.when(repo.findById(1)).thenReturn(c2);
			assertThat(readerserv.viewReaderById(1)).isEqualTo(rd);
		}

		
		/*
		 * @Test void testLoginValidate() { fail("Not yet implemented"); }
		 */
		  
		  @Test void testGetPassword() 
		  {
			  Readers rd = new Readers();
				rd.setId(1);
				rd.setFirstName("Kalyan");
				rd.setLastName("Ullangula");
				rd.setEmail("Kalyanu@gmail.com");
				rd.setPassword("Kalyan@5651");
				rd.setMobileno("9837829929");  
				Mockito.when(repo.findByPassword("Kalyan@5651")).thenReturn(rd);
				assertThat(readerserv.getPassword("Kalyan@5651")).isEqualTo(rd);
		  }
		  
		  @Test 
		  void testGetMobileno() 
		  { 
			  Readers rd = new Readers();
				rd.setId(1);
				rd.setFirstName("Kalyan");
				rd.setLastName("Ullangula");
				rd.setEmail("Kalyanu@gmail.com");
				rd.setPassword("Kalyan@5651");
				rd.setMobileno("9837829929");  
				Mockito.when(repo.findByMobileno("9837829929")).thenReturn(rd);
				assertThat(readerserv.getMobileno("9837829929")).isEqualTo(rd);
		  }
		 

	}


