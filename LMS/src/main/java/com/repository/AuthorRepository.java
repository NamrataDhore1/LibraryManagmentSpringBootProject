package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entites.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> 
{
	Author findByFirstName(String firstName) ;
	   
	   @Query("select Authors from Author Authors order by Authors.lastName")
	   List<Author> findByEmailSorted(String email);
}
