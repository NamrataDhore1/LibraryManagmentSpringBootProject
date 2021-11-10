package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entites.Books;
import com.service.BooksServImp;

@RestController
public class BooksCon {
	@Autowired
	BooksServImp bookservice;
	
	@PostMapping(path="/addBooks")
	public ResponseEntity<Books> addBook(@RequestBody Books book)
	{
		Books b1 = bookservice.addBook(book);
		ResponseEntity re = new ResponseEntity<Books>(b1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateBookDetails")
	public ResponseEntity<Books> updateBookDetails(@RequestBody Books book) throws Throwable
	{
		Books b2 = bookservice.updateBookDetails(book);
		ResponseEntity re = new ResponseEntity<Books>(b2,HttpStatus.OK);
		return  re;
		
	}
	@DeleteMapping(path="/removeBook")
	public ResponseEntity<Books> removeBook(@RequestBody Books bookid)
	{
		 bookservice.removeBook(bookid);
	     ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
	     return re;
		
	}
	@GetMapping("/searchBookByTitle/{title}")
	public ResponseEntity<List<Books>> searchBookByTitle(@PathVariable String title) 
	{
		List<Books> b3=bookservice.searchBookByTitle(title);
		ResponseEntity re=new ResponseEntity<List<Books>>(b3,HttpStatus.OK);
		return re;
	}
	@GetMapping("/searchBookBySubject/{subject}")
	public ResponseEntity<List<Books>> searchBookBySubject(@PathVariable String subject) 
	{
		List<Books> b3=bookservice.searchBookBySubject(subject);
		ResponseEntity re=new ResponseEntity<List<Books>>(b3,HttpStatus.OK);
		return re;
	}
	@GetMapping("/viewAllBooks")
	public ResponseEntity<Books> viewAllBooks()
	{
		List<Books> lb = bookservice.viewAllBooks();
		ResponseEntity re=new ResponseEntity<List<Books>>(lb,HttpStatus.OK);
		return re;
		
		
	}
	
	

}
