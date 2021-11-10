package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entites.BooksReturned;
import com.repository.BooksReturnedRepository;
@Service
public class BooksReturnedServImp implements BooksReturnedServ{
@Autowired
BooksReturnedRepository repo;
	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
     repo.save(returned);	
		return returned;
	}

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) throws Throwable {
		int rid = booksReturned.getId();
		//Supplier s1 = ()-> new ReturnNotFoundException("Book not Returned");
		BooksReturned b1 = repo.findById(rid).orElseThrow();
		//b1.setBooks(booksReturned.getBooks());
		b1.setDelayedDays(booksReturned.getDelayedDays());
		b1.setPenalty(booksReturned.getPenalty());
		b1.setPenaltyStatus(booksReturned.getPenaltyStatus());
		b1.setReturnedDate(booksReturned.getReturnedDate());
		repo.save(b1);
		
		return b1;
		
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		 List<BooksReturned> lbr = repo.findAll();
			return lbr;
	}

	@Override
	public List<BooksReturned> viewDelayedBooksList() {
		List<BooksReturned> bo1 = repo.findAll();
		return bo1;
	}
	
	


}
