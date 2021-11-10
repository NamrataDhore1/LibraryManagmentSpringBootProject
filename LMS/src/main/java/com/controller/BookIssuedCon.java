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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entites.BooksIssued;

import com.service.BookIssuedServImp;

@RestController
@RequestMapping("/api/booksissued")
public class BookIssuedCon {
	
	@Autowired 
	BookIssuedServImp bookissuedservice;
	@PostMapping("/addisbook")
	public BooksIssued addIssuedBook(@RequestBody BooksIssued issued)
	{
		 BooksIssued b1=bookissuedservice.addIssuedBook(issued);
		  return b1;
	}
	@PutMapping("/updateisbook")
	public ResponseEntity<BooksIssued> updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable 
	{
		BooksIssued  e1=bookissuedservice.updateIssuedBookDetails(booksIssued);
		
		ResponseEntity re=new ResponseEntity<BooksIssued>(e1,HttpStatus.OK);
		return re;
	}
	@DeleteMapping("/deleteisbook")
	public ResponseEntity<BooksIssued> deleteIssuedBooks(BooksIssued b2) throws Throwable
	{
		bookissuedservice.deleteIssuedBooks(b2);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	@GetMapping("/viewbookislist")
	public ResponseEntity<List<BooksIssued>> viewBooksIssuedList()
	{
		List<BooksIssued> v1=bookissuedservice.viewBooksIssuedList();
		ResponseEntity re=new ResponseEntity<>(v1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/findByIsId/{issueId}")
	public  ResponseEntity<BooksIssued> findByIssueId(@PathVariable int issueId)
	{
		BooksIssued c=bookissuedservice.findByIssueId(issueId);
		ResponseEntity re=new ResponseEntity<BooksIssued>(c,HttpStatus.OK);
		return re;
	}
	@GetMapping("/findByQuanSorted/{quantity}")
	public ResponseEntity<List<BooksIssued>> findByQuantitySorted(@PathVariable int quantity)
	{
		List<BooksIssued> c=bookissuedservice.findByQuantitySorted(quantity);
		ResponseEntity re=new ResponseEntity<List<BooksIssued>>(c,HttpStatus.OK);
		return re;
	}
	
		
	

}
