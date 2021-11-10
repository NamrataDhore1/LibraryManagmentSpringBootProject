package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.advices.BooksOrderNotFoundException;
import com.advices.DamagedBooksNotFoundException;
import com.advices.UserNotFoundException;
import com.entites.Admin;
import com.entites.Books;
import com.entites.BooksOrder;
import com.entites.DamagedBooks;
import com.entites.Users;
import com.repository.AdminRepository;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
import com.repository.DamagedBooksRepository;
import com.repository.UsersRepository;
@Service
public class AdminServImp implements AdminServ{
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private BooksOrderRepository booksorderrepo;
	@Autowired
	private DamagedBooksRepository damagedbookrepo;
	@Autowired
	private BooksRepository booksrepo;
	@Autowired
	private UsersRepository userrepo;
	@Override
	public Books addBooks(Books b) {
		booksrepo.save(b);
		return b;
	}

	@Override
	public Books updateBooks(Books books) throws Throwable {
		Supplier s1 = () -> new BookNotFoundException("Book Does not exist in the database");
		Books b2 = booksrepo.findById(books.getBookid()).orElseThrow(s1);
		b2.setTitle(books.getTitle());
		b2.setSubject(books.getSubject());
		b2.setBookcost(books.getBookcost());
		b2.setBookcost(books.getBookcost());
		b2.setQuantity(books.getQuantity());
		b2.setShelfdetails(books.getShelfdetails());
		b2.setIsbncode(books.getIsbncode());

		booksrepo.save(b2);
		return b2;
	}

	@Override
	public boolean removeBooks(Long bookid) throws Throwable {

		Supplier s = () -> new BookNotFoundException("Book Does not exist in the database");
		Books a = booksrepo.findById(bookid).orElseThrow(s);
		if (a != null) {
			booksrepo.deleteById(bookid);
			return true;
		}
		return false;

	}

	@Override
	public BooksOrder addBookOrder(BooksOrder booksOrder) {
		booksorderrepo.save(booksOrder);
		return booksOrder;
	}

	@Override
	public BooksOrder updateBookOrder(BooksOrder booksOrder) throws Throwable {
		Supplier s1 = () -> new BooksOrderNotFoundException("Order not Found");
		BooksOrder b1 = booksorderrepo.findById(booksOrder.getOrderId()).orElseThrow(s1);
		b1.setOrderId(booksOrder.getOrderId());
		b1.setOrderDate(booksOrder.getOrderDate());
		b1.setQuantity(booksOrder.getQuantity());
		// b1.setPublishers(booksOrder.getPublishers());
		b1.setOrderStatus(booksOrder.getOrderStatus());
		booksorderrepo.save(b1);
		return b1;
	}

	@Override
	public boolean removeBookOrder(int orderId) throws Throwable {
		Supplier s = () -> new BookNotFoundException("Book Does not exist in the database");
		BooksOrder a =booksorderrepo.findById(orderId).orElseThrow(s);
		if (a != null) {
			booksorderrepo.deleteById(orderId);
			return true;
		}
		return false;
		

	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		List<DamagedBooks> damagedBooks = damagedbookrepo.findAll();
		return damagedBooks;
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) throws Throwable {
		Supplier s1 = () -> new DamagedBooksNotFoundException("Book is not Damaged");
		DamagedBooks damagedBook = damagedbookrepo.findById(id).orElseThrow(s1);
		return damagedBook;
	}

	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks d) {
		return damagedbookrepo.save(d);
	}

	@Override
	public List<Books> searchBookByTitle(String title) {
		List<Books> b4 = booksrepo.searchBookByTitle(title);
		return b4;
	}

	@Override
	public List<Books> searchBookBySubject(String subject) {
		List<Books> b3 = booksrepo.searchBookByTitle(subject);
		return b3;
	}

	@Override
	public Admin addAdminDetails(Admin ad) {
		return adminrepo.save(ad);
	}

	@Override
	public Users validateUserDetails(Users user) throws UserNotFoundException {
		Optional<Users> u1 = userrepo.findById(user.getUserid());
		if (!u1.isEmpty()) {
			if (u1.get().getPassword().equals(user.getPassword())) {
				return user;
			} else {
				throw new UserNotFoundException("Wrong Password");
			}
		} else {
			throw new UserNotFoundException("User Not Found");
		}

	}

}
