package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entites.UserAddress;
import com.service.UserAddressServImp;

@RestController
@RequestMapping("/api")
public class UserAddressCon {
	@Autowired
	UserAddressServImp useraddservice;
	
	@PostMapping("/adduseraddress")
		public ResponseEntity<UserAddress> addUserAddress(@RequestBody UserAddress a) {
		 UserAddress a1=useraddservice.addUserAddress(a );
		 ResponseEntity re=new ResponseEntity<UserAddress>(a1,HttpStatus.OK);
		 return re;
	}
	@PutMapping("/updateuseraddress")
	
		public ResponseEntity<UserAddress> updateUserAddressDetails(@RequestBody UserAddress u2)throws Throwable
		{
			UserAddress u1= useraddservice.updateUserAddressDetails(u2); 
			ResponseEntity re = new ResponseEntity<UserAddress>(u1,HttpStatus.OK);
			return re;
			
		}
	 @DeleteMapping("/deleteuseraddres")
	  public ResponseEntity<UserAddressCon> deleteUserAddress(@RequestBody UserAddress d2){
	   useraddservice.deleteUserAddress(d2);
	   ResponseEntity re =new ResponseEntity<String>("deleted",HttpStatus.OK);
	   return re;
	 
	}
	 @GetMapping("/viewuseraddress")
	 public List<UserAddress> viewUserAddressList(){
		 List<UserAddress> v2=useraddservice.viewUserAddressList();
		 return v2;
		 
	 }
	 @GetMapping("/viewuseraddressid")
     public UserAddress viewAddressListByUserId( @RequestBody UserAddress id) {
		 useraddservice.viewAddressByUserId(id);
		 return id;
	 }
	 
	


}
