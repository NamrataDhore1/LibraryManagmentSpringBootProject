package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entites.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	@Query("select users from Users users order by users.email")
	Users findByEmail(String email);
	@Query("select users from Users users order by users.mobileno")
	Users findByMobileno(String mobileno);
}
