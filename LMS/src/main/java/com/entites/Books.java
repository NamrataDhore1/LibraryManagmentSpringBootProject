package com.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookid;

	@Column(name = "title", length = 250, nullable = false)
	@NotNull(message = "title cannot be null")
	private String title;

	@Column(name = "isbncode", length = 250, nullable = false)
	@Pattern(regexp = "^[0-9]+$")
	@NotNull(message = "isbncode cannot be null")
	private String isbncode;

	@Column(name = "subject", length = 250, nullable = false)
	@NotNull(message = "subject cannot be null")
	private String subject;

	@Column(name = "quantity", nullable = false)
	@NotNull(message = "quantity cannot be Null")
	private int quantity;

	@Column(name = "bookcost", length = 250, nullable = false)
	@NotNull(message = "Cost should not be blank")
	@DecimalMin(value = "100.0", message = "Amount must be a number at least 100")
	private double bookcost;

	@Column(name = "shelfdetails", length = 250, nullable = false)
	@NotNull
	private String shelfdetails;

	@Column(name = "publishedyear", length = 250, nullable = false)
	@NotNull
	private int publishedyear;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne
	private Admin admin;

	public String getIsbncode() {
		return isbncode;
	}

	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}

	public double getBookcost() {
		return bookcost;
	}

	public void setBookcost(double bookcost) {
		this.bookcost = bookcost;
	}

	public String getShelfdetails() {
		return shelfdetails;
	}

	public void setShelfdetails(String shelfdetails) {
		this.shelfdetails = shelfdetails;
	}

	public int getPublishedyear() {
		return publishedyear;
	}

	public void setPublishedyear(int publishedyear) {
		this.publishedyear = publishedyear;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
