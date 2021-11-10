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

import com.entites.Books;
import com.repository.BooksRepository;
import com.service.BooksServ;
	@SpringBootTest
	class BooksServiceImplTest {
		@Autowired
		BooksServ booksservice;
	    @MockBean
	    BooksRepository repo;
		@Test
		void testAddBook() {
			Books b1 = new Books();
			b1.setBookid((long) 1);
			b1.setTitle("FairyTales");
			b1.setSubject("Cindrella");
			b1.setPublishedyear(2007);
			b1.setIsbncode("8974764348397");
			b1.setQuantity(1);
			b1.setBookcost(500);
			b1.setShelfdetails("row1");
			Mockito.when(repo.save(b1)).thenReturn(b1);
			assertThat(booksservice.addBook(b1)).isEqualTo(b1);
		}

		@Test
		void testUpdateBookDetails() throws Throwable {
			Books b1 = new Books();
			b1.setBookid((long) 1);
			b1.setTitle("FairyTales");
			b1.setSubject("Cindrella");
			b1.setPublishedyear(2007);
			b1.setIsbncode("8974764348397");
			b1.setQuantity(1);
			b1.setBookcost(500);
			b1.setShelfdetails("row1");
			
			Optional<Books> b2 =  Optional.of(b1);
			Mockito.when(repo.findById((long) 1)).thenReturn(b2);
			Mockito.when(repo.save(b1)).thenReturn(b1);
			b1.setBookid((long) 1);
			b1.setTitle("History");
			b1.setSubject("World History");
			b1.setPublishedyear(2005);
			b1.setIsbncode("8978964508397");
			b1.setQuantity(1);
			b1.setBookcost(1000);
			b1.setShelfdetails("row2");
			
			assertThat(booksservice.updateBookDetails(b1)).isEqualTo(b1);
		}

		@Test
		void testRemoveBook() {
			Books b1 = new Books();
			b1.setBookid((long) 1);
			b1.setTitle("FairyTales");
			b1.setSubject("Cindrella");
			b1.setPublishedyear(2007);
			b1.setIsbncode("8974764348397");
			b1.setQuantity(1);
			b1.setBookcost(500);
			b1.setShelfdetails("row1");
			Optional<Books> b2=Optional.of(b1);
			Mockito.when(repo.findById((long) 1)).thenReturn(b2);
			Mockito.when(repo.existsById(b1.getBookid())).thenReturn(false);
			assertFalse(repo.existsById(b1.getBookid()));
		}

		
		/*
		 * @Test void testGetBookByTitle() { Books b1 = new Books();
		 * b1.setBookid((long)1); b1.setTitle("FairyTales"); b1.setSubject("Cindrella");
		 * b1.setPublishedyear(2007); b1.setIsbncode("8974764348397");
		 * b1.setQuantity(1); b1.setBookcost(500); b1.setShelfdetails("row1");
		 * List<Books> bookList = new ArrayList<Books>(); bookList.add(b1);
		 * Mockito.when(repo.searchBookByTitle("FairyTales")).thenReturn(bookList);
		 * assertThat(booksservice.searchBookByTitle("FairyTales")).isEqualTo(bookList);
		 * }
		 */
			/*
			 * @Test void testGetBookBySubject() { Books b1 = new Books();
			 * b1.setBookid((long) 1); b1.setTitle("FairyTales");
			 * b1.setSubject("Cindrella"); b1.setPublishedyear(2007);
			 * b1.setIsbncode("8974764348397"); b1.setQuantity(1); b1.setBookcost(500);
			 * b1.setShelfdetails("row1"); List<Books> bookList = new ArrayList<Books>();
			 * bookList.add(b1);
			 * Mockito.when(repo.searchBookBySubject("Cindrella")).thenReturn(bookList);
			 * assertThat(booksservice.searchBookBySubject("Cindrella")).isEqualTo(bookList)
			 * ; }
			 */
		 

		@Test
		void testViewAllBooks() {
			Books b1 = new Books();
			b1.setBookid((long) 1);
			b1.setTitle("FairyTales");
			b1.setSubject("Cindrella");
			b1.setPublishedyear(2007);
			b1.setIsbncode("8974764348397");
			b1.setQuantity(1);
			b1.setBookcost(500);
			b1.setShelfdetails("row1");
			
			Books b2 = new Books();
			b2.setBookid((long) 1);
			b2.setTitle("History");
			b2.setSubject("World History");
			b2.setPublishedyear(2005);
			b2.setIsbncode("8978964508397");
			b2.setQuantity(1);
			b2.setBookcost(1000);
			b2.setShelfdetails("row2");
			
			List<Books> bookList = new ArrayList<Books>();
			bookList.add(b1);
			bookList.add(b2);
			
			Mockito.when(repo.findAll()).thenReturn(bookList);
			assertThat(booksservice.viewAllBooks()).isEqualTo(bookList);
		}


}
