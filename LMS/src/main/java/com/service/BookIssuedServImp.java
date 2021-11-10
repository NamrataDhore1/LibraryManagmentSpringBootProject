package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.BookNotFoundException;
import com.entites.BooksIssued;
import com.repository.BooksIssuedRepository;

@Service
public class BookIssuedServImp implements BookIssuedServ {
	@Autowired
	private BooksIssuedRepository rep;

	@Override
	public BooksIssued addIssuedBook(BooksIssued issued) {
		return rep.save(issued);
	}

	@Override
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable {
		int issueId = booksIssued.getIssueId();
		  Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		  BooksIssued  b1=rep.findById((int) issueId).orElseThrow(s1);
		  b1.setIssueId(booksIssued.getIssueId());
		  b1.setIssueDate(booksIssued.getIssueDate());
		  b1.setDueDate(booksIssued.getDueDate());
		  b1.setQuantity(booksIssued.getQuantity());
		//  b1.setBooks(booksIssued.getBooks());
		  rep.save(b1) ;
		 
		    return rep.save(b1);

	}

	@Override
	public String deleteIssuedBooks(BooksIssued bookid) throws Throwable
	{		
		int issueId = bookid.getIssueId();
		  Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");		
		rep.delete(bookid);
		return "deleted";

	}

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
	      	
		List<BooksIssued> lc1 = rep.findAll();
		return lc1;

	}

	@Override
	public BooksIssued findByIssueId(int issueId)
	{
		 BooksIssued b=rep.findByIssueId(issueId);
		  return b;
		
	}

	@Override
	public List<BooksIssued> findByQuantitySorted(int quantity) {
		
		 List<BooksIssued> lc=rep.findByQuantitySorted(quantity);
		  return lc;
		
	}

	

}
