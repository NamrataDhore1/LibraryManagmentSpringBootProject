package com.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="booksreturned")
public class BooksReturned {
	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = " return date Should Not Be Null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnedDate;
	@NotNull
	private int delayedDays;

	@NotNull
	private double penalty;
	@Pattern(regexp = "^[A-Za-z ]{1,20}$", message = "Status must only be alphabets and whitespaces from 1 to 20 characters")
	private String penaltyStatus;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Books books;
	@OneToOne(cascade = CascadeType.MERGE)
	private Users users;
	

	public int getDelayedDays() {
		return delayedDays;
	}

	public void setDelayedDays(int delayedDays) {
		this.delayedDays = delayedDays;
	}

	public String getPenaltyStatus() {
		return penaltyStatus;
	}

	public void setPenaltyStatus(String penaltyStatus) {
		this.penaltyStatus = penaltyStatus;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	
	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	

}
