package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entites.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{
	 Books findByTitle(String title);
		
		@Query("Select book from Books book order by book.title ")
		List<Books> searchBookByTitle(String keyword);
		
	Books findBySubject(String subject);
		
		@Query("Select book from Books book order by book.subject")
		List<Books> searchBookBySubject(String keyword);
		

}
