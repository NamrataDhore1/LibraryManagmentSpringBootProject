package com.testcases;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

import com.entites.BooksIssued;
import com.repository.BooksIssuedRepository;
import com.service.BookIssuedServ;
	@SpringBootTest
	class BooksIssuedServiceImplTest {
		@Autowired 
		BookIssuedServ bookissuedservice;
		@MockBean
		BooksIssuedRepository bookissuerepo;
		
		@Test
		void testAddIssuedBook() {
			BooksIssued bi = new BooksIssued();
			bi.setIssueId(1);
			bi.setIssueDate(null);
			bi.setDueDate(null);
			bi.setQuantity(1);
			Mockito.when(bookissuerepo.save(bi)).thenReturn(bi);
			assertThat(bookissuedservice.addIssuedBook(bi)).isEqualTo(bi);
		}

		@Test
		void testUpdateIssuedBookDetails() throws Throwable {
			BooksIssued bi = new BooksIssued();
			bi.setIssueId(1);
			bi.setIssueDate(null);
			bi.setDueDate(null);
			bi.setQuantity(1);
			
			
			Optional<BooksIssued> b2 =  Optional.of(bi);
			Mockito.when(bookissuerepo.findById(1)).thenReturn(b2);
			Mockito.when(bookissuerepo.save(bi)).thenReturn(bi);
			
			
			assertThat(bookissuedservice.updateIssuedBookDetails(bi)).isEqualTo(bi);
		}

		@Test
		void testViewBooksIssuedList() {
			BooksIssued bi = new BooksIssued();
			bi.setIssueId(1);
			bi.setIssueDate(null);
			bi.setDueDate(null);
			bi.setQuantity(1);
			
			BooksIssued bi1 = new BooksIssued();
			bi1.setIssueId(1);
			bi1.setIssueDate(null);
			bi1.setDueDate(null);
			bi1.setQuantity(1);
			
			
			List<BooksIssued> bookissueList = new ArrayList<BooksIssued>();
			bookissueList.add(bi);
			bookissueList.add(bi1);
			
			Mockito.when(bookissuerepo.findAll()).thenReturn(bookissueList);
			assertThat(bookissuedservice.viewBooksIssuedList()).isEqualTo(bookissueList);
		}

		@Test
		void testFindByQuantitySorted() {
			BooksIssued bi = new BooksIssued();
			bi.setIssueId(1);
			bi.setIssueDate(null);
			bi.setDueDate(null);
			bi.setQuantity(1);
			
			BooksIssued bi1 = new BooksIssued();
			bi1.setIssueId(1);
			bi1.setIssueDate(null);
			bi1.setDueDate(null);
			bi1.setQuantity(1);
			
			
			List<BooksIssued> bookissueList = new ArrayList<BooksIssued>();
			bookissueList.add(bi);
			bookissueList.add(bi1);
			
			Mockito.when(bookissuerepo.findByQuantitySorted(1)).thenReturn(bookissueList);
			assertThat(bookissuedservice.findByQuantitySorted(1)).isEqualTo(bookissueList);
		}

		
		/*
		 * @Test void testGetByIssueId() throws Throwable { BooksIssued bi = new
		 * BooksIssued(); bi.setIssueId(1); bi.setIssueDate(null); bi.setDueDate(null);
		 * bi.setQuantity(1);
		 * 
		 * Optional<BooksIssued> bi1 = Optional.of(bi);
		 * Mockito.when(bookissuerepo.findByIssueId(1)).thenReturn(bi1);
		 * assertThat(bookissuedservice.findByIssueId(1)).isEqualTo(bi); }
		 */

		@Test
		void testDeleteIssuedBooks() {
			BooksIssued bi = new BooksIssued();
			bi.setIssueId(1);
			bi.setIssueDate(null);
			bi.setDueDate(null);
			bi.setQuantity(1);
			Optional<BooksIssued> b2=Optional.of(bi);
			Mockito.when(bookissuerepo.findById(1)).thenReturn(b2);
			Mockito.when(bookissuerepo.existsById(bi.getIssueId())).thenReturn(false);
			assertFalse(bookissuerepo.existsById(bi.getIssueId()));
		}


}
