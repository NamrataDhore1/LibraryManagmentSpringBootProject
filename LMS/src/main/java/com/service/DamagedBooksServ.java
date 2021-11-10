package com.service;

import java.util.List;

import com.entites.DamagedBooks;

public interface DamagedBooksServ {
	public DamagedBooks addDamagedBooks(DamagedBooks dbookid);
	public DamagedBooks updateDamagedBookDetails(DamagedBooks dbookid) throws Throwable;
	public List<DamagedBooks> viewDamagedBooksList();
	public DamagedBooks viewDamagedBookById(int id) throws Throwable;

}
