package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entites.BooksOrder;

public interface BooksOrderRepository extends JpaRepository<BooksOrder,Integer>{

}
