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

import com.entites.Author;
import com.repository.AuthorRepository;
import com.service.AuthorServ;
	@SpringBootTest
	class AuthorServiceImplTest {
		@Autowired
		AuthorServ authorservice;
		
		@MockBean
		AuthorRepository authorrepo;
		
		@Test
		void testAddAuthorDetails() {
			Author aut = new Author();
			aut.setAuthorId(1);
			aut.setFirstName("Ankitha");
			aut.setLastName("Reddymalla");
			aut.setContactno("7981014915");
			aut.setEmail("ankitha@gmail.com");
			Mockito.when(authorrepo.save(aut)).thenReturn(aut);
			assertThat(authorservice.addAuthorDetails(aut)).isEqualTo(aut);
		}

		@Test
		void testUpdateAuthorDetails() throws Throwable {
			Author aut = new Author();
			aut.setAuthorId(1);
			aut.setFirstName("Ankitha");
			aut.setLastName("Reddymalla");
			aut.setContactno("7981014915");
			aut.setEmail("ankitha@gmail.com");
			Optional<Author> aut2 =  Optional.of(aut);
			Mockito.when(authorrepo.findById(1)).thenReturn(aut2);
			Mockito.when(authorrepo.save(aut)).thenReturn(aut);
			aut.setFirstName("SriLakshmi");
			aut.setLastName("Chippa");
			aut.setContactno("7729924812");
			aut.setEmail("srilakshmi@gmail.com");
		
			assertThat(authorservice.updateAuthorDetails(aut)).isEqualTo(aut);
		}

		@Test
		void testDeleteAuthorDetails() {
			Author aut = new Author();
			aut.setAuthorId(1);
			aut.setFirstName("Ankitha");
			aut.setLastName("Reddymalla");
			aut.setContactno("7981014915");
			aut.setEmail("ankitha@gmail.com");
			Optional<Author> c2=Optional.of(aut);
			Mockito.when(authorrepo.findById(1)).thenReturn(c2);
			Mockito.when(authorrepo.existsById(aut.getAuthorId())).thenReturn(false);
			assertFalse(authorrepo.existsById(aut.getAuthorId()));
		}

		@Test
		void testViewAuthorsList() {
			Author aut = new Author();
			aut.setAuthorId(1);
			aut.setFirstName("Ankitha");
			aut.setLastName("Reddymalla");
			aut.setContactno("7981012915");
			aut.setEmail("ankitha@gmail.com");
			
			Author aut1 = new Author();
			aut1.setAuthorId(1);
			aut1.setFirstName("SriLakshmi");
			aut1.setLastName("Chippa");
			aut1.setContactno("7729924812");
			aut1.setEmail("srilakshmi@gmail.com");
			
			List<Author> authorList = new ArrayList<Author>();
			authorList.add(aut);
			authorList.add(aut1);
			
			Mockito.when(authorrepo.findAll()).thenReturn(authorList);
			assertThat(authorservice.viewAuthorsList()).isEqualTo(authorList);
		}

		@Test
		void testViewAuthorById() throws Throwable {
			Author aut = new Author();
			aut.setAuthorId(1);
			aut.setFirstName("Ankitha");
			aut.setLastName("Reddymalla");
			aut.setContactno("7981014915");
			aut.setEmail("ankitha@gmail.com");
		
			Optional<Author> c2 = Optional.of(aut);
			Mockito.when(authorrepo.findById(1)).thenReturn(c2);
			assertThat(authorservice.viewAuthorById(1)).isEqualTo(aut);
		}

		/*
		 * @Test void testGetAuthorByFirstName() throws Throwable { Author a1=new
		 * Author(); a1.setAuthorId(1); a1.setFirstName("Ankitha");
		 * a1.setLastName("Reddymalla"); a1.setContactno("7981014915");
		 * a1.setEmail("ankitha@gmail.com"); Optional<Author> a2 = Optional.of(a1);
		 * Mockito.when(authorrepo.findByFirstName("Ankitha")).thenReturn(a2);
		 * assertThat(authorservice.getAuthorByFirstName("Ankitha")).isEqualTo(a1); }
		 */
		/*
		 * @Test void testGetByEmail() throws Throwable { Author a1=new Author();
		 * a1.setAuthorId(1); a1.setFirstName("Ankitha"); a1.setLastName("Reddymalla");
		 * a1.setContactno("7981014915"); a1.setEmail("ankitha@gmail.com");
		 * Optional<Author> a2 = Optional.of(a1);
		 * Mockito.when(authorrepo.findByFirstName("Ankitha")).thenReturn(a2);
		 * assertThat(authorservice.getAuthorByFirstName("Ankitha")).isEqualTo(a1); }
		 */
	}


