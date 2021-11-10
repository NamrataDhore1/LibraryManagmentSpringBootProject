package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entites.DamagedBooks;
import com.service.DamagedBooksServImp;

@RestController
@RequestMapping("/api")
public class DamagedBooksCon {
	@Autowired
	DamagedBooksServImp damagedbookserv;
	
	@GetMapping(path="/getCode/{cid}")
	public ResponseEntity<DamagedBooks> viewDamagedBookById(@PathVariable int id) throws Throwable
	{
	    DamagedBooks db =damagedbookserv.viewDamagedBookById(id);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(db,HttpStatus.OK);
		return re;
		
	}
	@PostMapping(path="/addDamagedBooks")
	public ResponseEntity<DamagedBooks> addDamagedBooks(@RequestBody DamagedBooks dbookid) {
		
		DamagedBooks db1=damagedbookserv.addDamagedBooks(dbookid);
		ResponseEntity re=new ResponseEntity<DamagedBooks>(db1,HttpStatus.OK);
		return re;
		
	}
	@PutMapping(path="/updateDamagedBooks")
	public ResponseEntity<DamagedBooks> updateDamagedBookDetails(@RequestBody DamagedBooks dbookid) throws Throwable
	{
		DamagedBooks db2 = damagedbookserv.updateDamagedBookDetails(dbookid);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(db2,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getCoder")
	public ResponseEntity<DamagedBooks> viewDamagedBooksList() {
		
		List<DamagedBooks> db3=damagedbookserv.viewDamagedBooksList();
		ResponseEntity re = new ResponseEntity<List<DamagedBooks>>(db3,HttpStatus.OK);
		return re;
		
	}

}


