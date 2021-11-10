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

import com.entites.Author;
import com.service.AuthorServ;
@RestController
@RequestMapping("/lms")
public class AuthorCon {
	
	@Autowired
	AuthorServ serv;

	@PostMapping("/addAuthor")
	public ResponseEntity<Author> addAuthorDetails(@RequestBody Author a){
		Author a1=serv.addAuthorDetails(a);
		ResponseEntity re=new ResponseEntity<Author>(a1,HttpStatus.OK);
		return re;
	}

	@PutMapping("/updateAuthor")
	public ResponseEntity<Author> updateAuthorDetails(@RequestBody Author a) throws Throwable
	{
		Author a2=serv.updateAuthorDetails(a);
		ResponseEntity re=new ResponseEntity<Author>(a2,HttpStatus.OK);
		return re;
	}

	@DeleteMapping("/deleteAuthor")
	public ResponseEntity<String> deleteAuthorDetails(@RequestBody Author a) throws Throwable
	{
		serv.deleteAuthorDetails(a);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}

	@GetMapping("/viewAuthor")
	public ResponseEntity<List<Author>> viewAuthorsList(){
		List<Author> list=serv.viewAuthorsList();
		ResponseEntity re=new ResponseEntity<List<Author>>(list,HttpStatus.OK);
		return re;
	}

	@GetMapping("/viewAuthorbyId/{authorId}")
	public ResponseEntity<Author> viewAuthorById(@PathVariable int authorId){
		Author a1=serv.viewAuthorById(authorId);
		ResponseEntity re=new ResponseEntity<Author>(a1,HttpStatus.OK);
		return re;
	}

	
	  @GetMapping("/getAuthor/{firstName}") 
	  public ResponseEntity<Author> getAuthorByFirstName(@PathVariable String firstName)
	  {
		  Author a2=serv.getAuthorByFirstName(firstName);
	  ResponseEntity re=new ResponseEntity<Author>(a2,HttpStatus.OK); return re; }
	  
	  @GetMapping("/getAuthor/{email}")
	  public ResponseEntity<List<Author>> findByEmailSorted(@PathVariable String email)
	  { List<Author> l1=serv.findByEmailSorted(email);
	  ResponseEntity re=new ResponseEntity<List<Author>>(l1,HttpStatus.OK);
	  return re; 
	  }
	  }
	 

