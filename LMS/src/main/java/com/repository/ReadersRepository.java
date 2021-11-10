package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advices.ReaderNotFoundException;
import com.entites.Readers;

public interface ReadersRepository extends JpaRepository<Readers,Integer> {
	@Query("Select password from Readers password order by id.password")	
	Readers findByPassword(String password);
	@Query("Select mobileno from Readers mobileno order by id.mobileno")		
	   Readers findByMobileno(String mobileno);
	
}



