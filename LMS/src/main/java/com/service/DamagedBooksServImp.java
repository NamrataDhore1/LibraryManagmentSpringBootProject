package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.DamagedBooksNotFoundException;
import com.entites.DamagedBooks;
import com.repository.DamagedBooksRepository;

@Service
public class DamagedBooksServImp implements DamagedBooksServ
{
  @Autowired
  DamagedBooksRepository repo;
	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks dbookid) {
		  repo.save(dbookid);
			return dbookid;
	}

	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooks dbookid) throws Throwable {
		 int did = dbookid.getId();
		Supplier s1 = ()-> new  DamagedBooksNotFoundException("Book is not Damaged");
		 DamagedBooks db = repo.findById(did).orElseThrow();
		 db.setBooks(dbookid.getBooks());
		 db.setDescription(dbookid.getDescription());
		 db.setQuantity(dbookid.getQuantity());
		 repo.save(db);
		 
		return db;
		
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		Supplier s1 = ()-> new DamagedBooksNotFoundException("Book is not Damaged");
		List<DamagedBooks> b= repo.findAll();//.orElseThrow();
		return b;
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) throws Throwable {
		Supplier s1 = ()-> new DamagedBooksNotFoundException("Book is not Damaged");
		DamagedBooks b= repo.findById(id).orElseThrow();
		return b;
	}

}
