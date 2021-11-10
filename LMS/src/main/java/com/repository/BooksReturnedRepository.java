package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entites.BooksReturned;

public interface BooksReturnedRepository extends JpaRepository<BooksReturned,Integer> {

}
