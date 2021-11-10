package com.service;

import java.util.List;

import com.entites.Books;

public interface BooksServ {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book) throws Throwable;
	public String removeBook(Books bookid);
	public List<Books> searchBookByTitle(String keyword);
	public List<Books> searchBookBySubject(String keyword);
	public List<Books> viewAllBooks();
	

}
