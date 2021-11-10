package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entites.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{
	@Query("Select login from Login login order by loginId")
	List<Login> findByusername(String username);
}
