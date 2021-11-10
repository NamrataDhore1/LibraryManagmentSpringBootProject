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

import com.entites.DamagedBooks;
import com.repository.DamagedBooksRepository;
import com.service.DamagedBooksServ;
	@SpringBootTest
	class DamagedBooksServiceImplTest {
		@Autowired
		DamagedBooksServ damagedbookservice;
		@MockBean
		DamagedBooksRepository damagedbooksrepo;
		@Test
		void testAddDamagedBooks() {
			DamagedBooks db = new DamagedBooks();
			db.setId(1);
			db.setDescription("missingpages");
			db.setQuantity(1);
			Mockito.when(damagedbooksrepo.save(db)).thenReturn(db);
			assertThat(damagedbookservice.addDamagedBooks(db)).isEqualTo(db);
		}

		@Test
		void testUpdateDamagedBookDetails() throws Throwable {
			DamagedBooks db = new DamagedBooks();
			db.setId(1);
			db.setDescription("missingpages");
			db.setQuantity(1);
			Optional<DamagedBooks> c2 =  Optional.of(db);
			Mockito.when(damagedbooksrepo.findById(1)).thenReturn(c2);
			Mockito.when(damagedbooksrepo.save(db)).thenReturn(db);
			assertThat(damagedbookservice.updateDamagedBookDetails(db)).isEqualTo(db);
		}

		@Test
		void testViewDamagedBooksList() {
			DamagedBooks db = new DamagedBooks();
			db.setId(1);
			db.setDescription("missingpages");
			db.setQuantity(1);
			
			DamagedBooks db1 = new DamagedBooks();
			db1.setId(2);
			db1.setDescription("Book damaged");
			db1.setQuantity(1);
			
			List<DamagedBooks> damagedList = new ArrayList<DamagedBooks>();
			damagedList.add(db);
			damagedList.add(db1);
			
			Mockito.when(damagedbooksrepo.findAll()).thenReturn(damagedList);
			assertThat(damagedbookservice.viewDamagedBooksList()).isEqualTo(damagedList);
		}

		@Test
		void testViewDamagedBookById() throws Throwable {
			DamagedBooks db = new DamagedBooks();
			db.setId(1);
			db.setDescription("missingpages");
			db.setQuantity(1);
			Optional<DamagedBooks> c2 = Optional.of(db);
			Mockito.when(damagedbooksrepo.findById(1)).thenReturn(c2);
			assertThat(damagedbookservice.viewDamagedBookById(1)).isEqualTo(db);
		}

	}


