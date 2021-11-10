package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BooksOrderNotFoundException;
import com.entites.BooksOrder;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
@Service
public class BooksOrderServImp implements BooksOrderServ{

	 @Autowired
	 BooksOrderRepository rep;
	// @Autowired
	 //BooksRepository repo;
	  @Override
	public BooksOrder placeBooksOrder(BooksOrder orderdetails) 
	{
		return rep.save(orderdetails);
	   
	}

	@Override
	public String cancelOrder(BooksOrder orderId) 
	{
		rep.delete(orderId);
		return "Order Cancelled";
	}

	@Override
	public BooksOrder updateOrder(BooksOrder order) throws Throwable {
		int orderid = order.getOrderId();
		Supplier s2 = ()-> new BooksOrderNotFoundException("Order not Found");
		BooksOrder bo=rep.findById(orderid).orElseThrow();
	//	bo.setBooks(order.getBooks());
		bo.setQuantity(order.getQuantity());
		bo.setOrderDate(order.getOrderDate());
		bo.setOrderStatus(order.getOrderStatus());
		rep.save(bo);		
		return bo;
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		List<BooksOrder> lbo = rep.findAll();
		return lbo;
	}

	@Override
	public BooksOrder viewOrderById(int orderId) throws Throwable {
		Supplier s2 = ()-> new BooksOrderNotFoundException("Order not Found");
		BooksOrder bo1 = rep.findById(orderId).orElseThrow();
		return bo1;
	}

}
