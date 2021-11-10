package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entites.BooksIssued;
import com.entites.BooksReturned;
import com.service.BooksReturnedServImp;

@RestController
@RequestMapping("/api")
public class BooksReturnedCon {
	@Autowired
	BooksReturnedServImp bookreturnservice;
	@PostMapping("/returnbooks")
	public BooksReturned returnBooks(@RequestBody BooksReturned returned)
	{
		 BooksReturned b1=bookreturnservice.returnBooks(returned);
		  return b1;
	}
	@PutMapping("/updatereturnbdetails")
	public ResponseEntity<BooksReturned> updateReturnedBookDetails(BooksReturned booksReturned) throws Throwable
	{
         BooksReturned e1=bookreturnservice.updateReturnedBookDetails(booksReturned);
		
		ResponseEntity re=new ResponseEntity<BooksReturned>(e1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/viewbooklist")
	public ResponseEntity<List<BooksReturned>> viewReturnedBooksList()
	{
		List<BooksReturned> v1=bookreturnservice.viewReturnedBooksList();
		ResponseEntity re=new ResponseEntity<>(v1,HttpStatus.OK);
		return re;

	}
	/*
	 * public List<BooksReturned> viewDelayedBooksList() {
	 * 
	 * }
	 */
}
