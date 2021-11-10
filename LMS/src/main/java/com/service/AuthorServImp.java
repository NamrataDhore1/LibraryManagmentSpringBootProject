package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AuthorNotFoundException;
import com.advices.BookNotFoundException;
import com.entites.Author;
import com.repository.AuthorRepository;
@Service
public class AuthorServImp implements AuthorServ {
	   @Autowired
	      private AuthorRepository authorrepo;
	      
		@Override
		public Author addAuthorDetails(Author author)
		{
			authorrepo.save(author);
			return author;
		}

		@Override
		public Author updateAuthorDetails(Author author) throws Throwable
		{
			  Supplier s1= ()->new AuthorNotFoundException("Author Does not exist in the database");
			Author existingauthor=authorrepo.findById(author.getAuthorId()).orElseThrow(s1);
			existingauthor.setFirstName(author.getFirstName());
			existingauthor.setLastName(author.getLastName());
			existingauthor.setEmail(author.getEmail());
			existingauthor.setContactno(author.getContactno());
			//existingauthor.setBooks(author.getBooks());
			authorrepo.save(author);
			return author;
		}

		@Override
		public String deleteAuthorDetails(Author author) throws Throwable
		{
			 Supplier s1= ()->new AuthorNotFoundException("Author Does not exist in the database");		
			authorrepo.delete(author);
			return "deleted";
		}

		@Override
		public List<Author> viewAuthorsList() {
			List<Author> l1=authorrepo.findAll();
			return l1;
		}

		@Override
		public Author viewAuthorById(int authorId) {
		   Author a1=authorrepo.findById(authorId).orElseThrow();
			return a1;
		}

		
		  @Override
		  public Author getAuthorByFirstName(String firstName) 
		 { 
			  Author a1=authorrepo.findByFirstName(firstName); 
			  return a1; 
			  }
		  
		  @Override
		  public List<Author> findByEmailSorted(String email) 
		  { 
			  List<Author> a1=authorrepo.findByEmailSorted(email); 
			  return a1;
			  }
		 

		

}
