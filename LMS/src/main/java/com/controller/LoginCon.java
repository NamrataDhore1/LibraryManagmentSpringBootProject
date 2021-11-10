package com.controller;

import java.util.List;

import javax.security.auth.spi.LoginModule;

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

import com.entites.Login;
import com.service.LoginServ;
import com.service.LoginServImp;

@RestController
@RequestMapping("/api")
public class LoginCon {
	@Autowired
	LoginServImp logSe;
	
	@PostMapping("/addLoginDetails")
	public ResponseEntity<Login>  addLoginDetails(@RequestBody Login lo) {
		Login lm=logSe.addLoginDetails(lo);
		ResponseEntity<Login> re=new ResponseEntity <Login>(lm,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping(path="/updateLoginDetails")
	public ResponseEntity<Login> updateLoginDetails(@RequestBody Login lmm) throws Throwable{
		Login up=logSe.updateLoginDetails(lmm);
		ResponseEntity<Login> re=new ResponseEntity <Login>(up,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteLoginDetails")
	public ResponseEntity<Login> deleteLoginDetails(@RequestBody Login del){
		logSe.deleteLoginDetails(del);
		ResponseEntity<Login> re=new ResponseEntity <Login>(del,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/ViewusersList")
	public ResponseEntity<List<Login>> viewloginlist(){
		List<Login> lc1=logSe.viewloginList();
		ResponseEntity<List<Login>> re=new ResponseEntity <List<Login>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/ViewusersbyId/{userid}")
	public ResponseEntity<Login> viewuserById(@PathVariable int userid ) throws Throwable 
	{
		Login u=logSe.viewusersbyid(userid);
		ResponseEntity< Login> re=new ResponseEntity<Login>(u,HttpStatus.OK);
		return re;
		
	}
	
	@GetMapping(path="/viewusersbyName/{username}")
	public ResponseEntity<List<Login>> getByusername(@PathVariable String username ) 
	{
		List<Login> usn=logSe.getByusername(username);
		ResponseEntity<List<Login>> re=new ResponseEntity<List<Login>>(usn,HttpStatus.OK);
		return re;
	}
	
	



}
