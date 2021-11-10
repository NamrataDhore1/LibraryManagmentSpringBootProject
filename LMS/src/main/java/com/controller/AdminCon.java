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

import com.entites.Admin;
import com.entites.Books;
import com.entites.BooksOrder;
import com.entites.DamagedBooks;
import com.entites.Users;
import com.service.AdminServ;



@RestController
@RequestMapping("/api")
public class AdminCon {
	@Autowired
	private AdminServ adminservice;
	@PostMapping("/admindetails")
	public ResponseEntity<Books> addAdminDetails(@RequestBody Admin admin) {
		Admin b1 = adminservice.addAdminDetails(admin);
		ResponseEntity re = new ResponseEntity<Admin>(b1, HttpStatus.OK);
		return re;
	}
	

	@PostMapping("/addBooks")
	public ResponseEntity<Books> addBooks(@RequestBody Books book) {
		Books b1 = adminservice.addBooks(book);
		ResponseEntity re = new ResponseEntity<Books>(b1, HttpStatus.OK);
		return re;
	}

	@PutMapping(path = "/updateBooks")
	public ResponseEntity<Books> updateBooks(@RequestBody Books book) throws Throwable {
		Books b1 = adminservice.updateBooks(book);

		ResponseEntity re = new ResponseEntity<Books>(b1, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteBooks/{bookid}")
	public ResponseEntity<String> deleteById(@PathVariable  Long bookid) throws Throwable {
		adminservice.removeBooks(bookid);

		ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}

	@PostMapping("/addBooksOrder")
	public ResponseEntity<BooksOrder> addBooksOrder(@RequestBody BooksOrder bookOrder) {
		BooksOrder b1 = adminservice.addBookOrder(bookOrder);
		ResponseEntity re = new ResponseEntity<BooksOrder>(b1, HttpStatus.OK);
		return re;
	}

	@PutMapping(path = "/updateBooksOrder")
	public ResponseEntity<BooksOrder> updateBookOrder(@RequestBody BooksOrder booksOrder) throws Throwable {
		BooksOrder b1 = adminservice.updateBookOrder(booksOrder);

		ResponseEntity re = new ResponseEntity<BooksOrder>(b1, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteBooksOrder/{orderId}")
	public ResponseEntity<String> deleteById1(@PathVariable int orderId) throws Throwable {
		adminservice.removeBookOrder(orderId);

		ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}

	@GetMapping("/SearchBookTitle/{title}")
	public ResponseEntity<List<Books>> searchBookByTitle(@PathVariable String title) {
		List<Books> c = adminservice.searchBookByTitle(title);
		ResponseEntity re = new ResponseEntity<List<Books>>(c, HttpStatus.OK);
		return re;
	}
	@GetMapping("/SearchBookSubject/{subject}")
	public ResponseEntity<List<Books>> searchBookBySubject(@PathVariable String subject) {
		List<Books> c = adminservice.searchBookBySubject(subject);
		ResponseEntity re = new ResponseEntity<List<Books>>(c, HttpStatus.OK);
		return re;
	}
	@PostMapping("/addDamagedBooks//{ DamagedBooks}")
	public ResponseEntity<DamagedBooks> addBooksOrder(@RequestBody DamagedBooks damagedBooks) {
		DamagedBooks b1 = adminservice.addDamagedBooks(damagedBooks);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(b1, HttpStatus.OK);
		return re;
	}
	

	@GetMapping("/getDamagedBooks")
	public ResponseEntity<List<DamagedBooks>> getDamagedBooks() {
		List<DamagedBooks> lc1 = adminservice.viewDamagedBooksList();
		ResponseEntity re = new ResponseEntity<List<DamagedBooks>>(lc1, HttpStatus.OK);
		return re;
	}

	@GetMapping(path = "/getDamagedBooks/{id}")
	public ResponseEntity<DamagedBooks> getDamagedBooksId(@PathVariable int id) throws Throwable {
		DamagedBooks c1 = adminservice.viewDamagedBookById(id);

		ResponseEntity re = new ResponseEntity<DamagedBooks>(c1, HttpStatus.OK);
		return re;
	}
	@PostMapping("/usersvalidate")
	  public ResponseEntity<Users> validateUserDetails(@RequestBody Users user) throws Throwable
	   
	   {
		   Users login=adminservice.validateUserDetails(user);
		   ResponseEntity re = new ResponseEntity<Users>(login,HttpStatus.OK);
		   return re;
	   }

}


