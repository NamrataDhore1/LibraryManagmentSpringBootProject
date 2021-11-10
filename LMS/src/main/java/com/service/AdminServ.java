package com.service;

import java.util.List;

import com.entites.Admin;
import com.entites.Books;
import com.entites.BooksOrder;
import com.entites.DamagedBooks;
import com.entites.Users;

public interface AdminServ {
	public Admin addAdminDetails(Admin ad);

	public Books addBooks(Books b);

	public Users validateUserDetails(Users user) throws Throwable;

	public Books updateBooks(Books books) throws Throwable;

	public  boolean removeBooks(Long bookid) throws Throwable;

	public BooksOrder addBookOrder(BooksOrder booksOrder);

	public BooksOrder updateBookOrder(BooksOrder booksOrder) throws Throwable;

	public boolean removeBookOrder(int orderId)throws Throwable ;

	public List<DamagedBooks> viewDamagedBooksList();

	 DamagedBooks viewDamagedBookById(int id) throws Throwable;

	public DamagedBooks addDamagedBooks(DamagedBooks d);

	public List<Books> searchBookByTitle(String title);

	public List<Books> searchBookBySubject(String subject);

	

	

}


