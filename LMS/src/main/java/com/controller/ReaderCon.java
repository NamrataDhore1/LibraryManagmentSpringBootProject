package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advices.ReaderNotFoundException;
import com.entites.Readers;
import com.service.ReaderServImp;

@RestController
@RequestMapping("/api")
public class ReaderCon {
	@Autowired
	ReaderServImp readerserv;
	@PostMapping("/register")	
	public Readers register(@RequestBody Readers r) {
		Readers r1=readerserv.register(r);	
	return r1;
	}
	@DeleteMapping("/deleteReader")
	public ResponseEntity<Readers> deleteReader(@RequestBody int id){
		String r1= readerserv.deleteReader(id);
		ResponseEntity re = new ResponseEntity<String>("deleted",HttpStatus.OK);
		return re;
	}
	@PutMapping("/updateReader")
	public ResponseEntity<Readers> updateReaderDetails(@RequestBody Readers reader)throws Throwable
	{
		Readers e1=readerserv.updateReaderDetails(reader);
		ResponseEntity re = new ResponseEntity<Readers>(e1,HttpStatus.OK);
		return re;
	}
	@PatchMapping(path = "/login")
	public String loginValidate(@RequestParam String username, String password) throws ReaderNotFoundException {	
		readerserv.loginValidate(username, password);
		return "Login Successful!!!";
	}
	@GetMapping("/viewreaderlist")
	public ResponseEntity<List<Readers>> viewReadersList() 
	{
		List<Readers> r3 = readerserv.viewReadersList();
		ResponseEntity re = new ResponseEntity<List<Readers>>(r3,HttpStatus.OK);
		return re;
	}
	@GetMapping("/viewreaderid/{id}")
	public ResponseEntity<Readers> viewReaderById(@PathVariable int id) {
		
		Readers m1=readerserv.viewReaderById(id);
		ResponseEntity re = new ResponseEntity<Readers>(m1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getPassword")
	public ResponseEntity<Readers> getPassword(@RequestBody String password)
	{
		Readers r1=readerserv.getPassword(password);
		ResponseEntity re = new ResponseEntity<Readers>(r1,HttpStatus.OK);
		return re;
		
	}
	@GetMapping("/getMobileno")
	public ResponseEntity<Readers> getMobileno(@RequestBody String mobileno)
	{
		Readers re=readerserv.getMobileno(mobileno);
		ResponseEntity rm = new ResponseEntity<Readers>(re,HttpStatus.OK);
		return rm;
	}
	

}
