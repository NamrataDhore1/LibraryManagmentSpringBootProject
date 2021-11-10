package com.service;

import java.util.List;

import com.entites.BooksReturned;
public interface BooksReturnedServ {
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) throws Throwable;
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList();

}
