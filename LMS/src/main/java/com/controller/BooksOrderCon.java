package com.controller;


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
import com.entites.BooksOrder;
import com.service.BooksOrderServImp;
import com.service.BooksServImp;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksOrderCon {
	@Autowired
	BooksOrderServImp bookorderservice;
	//@Autowired
	//BooksServImp bookservice; 
	
	@PostMapping(path="/placeOrder")
	public ResponseEntity<BooksOrder> placeBooksOrder(@RequestBody BooksOrder orderdetails) {
		
		BooksOrder ord1 =bookorderservice.placeBooksOrder(orderdetails);
		ResponseEntity re=new ResponseEntity<BooksOrder>(ord1,HttpStatus.OK);
		return re;
		
	}
	@DeleteMapping(path="/cancelOrder")
	public ResponseEntity<String> cancelOrder(@RequestBody BooksOrder orderId)
	{
		    bookorderservice.cancelOrder(orderId);
		     ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		     return re;
	}
	@PutMapping(path="/updateOrder")
	public ResponseEntity<BooksOrder> updateOrder(@RequestBody BooksOrder order) throws Throwable
	{
		BooksOrder ord1 = bookorderservice.updateOrder(order);
		ResponseEntity re = new ResponseEntity<BooksOrder>(ord1,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/viewOrderList")
	public ResponseEntity<List<BooksOrder>> viewOrdersList() {
		
		List<BooksOrder> v1=bookorderservice.viewOrdersList();
		ResponseEntity re=new ResponseEntity<>(v1,HttpStatus.OK);
		return re;
		
	}
	@GetMapping(path="/viewOrderById/{orderId}")
	public ResponseEntity<BooksOrder> viewOrderById(@PathVariable int orderId) throws Throwable
	{
		BooksOrder bo2=bookorderservice.viewOrderById(orderId);
		ResponseEntity re = new ResponseEntity<BooksOrder>(bo2,HttpStatus.OK);
		return re;
		
	}

}
