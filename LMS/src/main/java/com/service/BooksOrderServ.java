package com.service;

import java.util.List;

import com.entites.BooksOrder;

public interface BooksOrderServ {
	public BooksOrder placeBooksOrder(BooksOrder orderdetails);
	public String cancelOrder(BooksOrder orderId);
	public BooksOrder updateOrder(BooksOrder order) throws Throwable;
	public List<BooksOrder> viewOrdersList();
	public BooksOrder viewOrderById(int orderId) throws Throwable;

}
