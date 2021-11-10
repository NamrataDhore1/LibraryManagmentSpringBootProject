package com.entites;

import java.util.Date;
import java.util.List;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bookissued")
public class BooksIssued {
	@Id   
		private int issueId;
	    // @Pattern(regexp = "^[0-9]{1,14}$", message = "The issueid must be a number and must have 14 number") 
			
			  @ManyToOne(cascade=CascadeType.MERGE)
			 private Books books;		
				  @OneToOne(cascade=CascadeType.MERGE)
				   private Users users;
				 
		 @Column(name = "issueDate", nullable = false)
		 @NotNull(message = " issueDate Should Not Be Null")
		 @DateTimeFormat(pattern = "yyyy-MM-dd")
	
		private Date issueDate;
		 @Column(name="quantity",nullable=false)
		 @NotNull(message = "quantity Should Not Be Null") 
		private int quantity;
		 @NotNull(message="duedate cannot be null") 
		 @DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dueDate;
		
		public int getIssueId() {
			return issueId;
		}
		public void setIssueId(int issueId) {
			this.issueId = issueId;
		}
		
		public Date getIssueDate() {
			return issueDate;
		}
		public void setIssueDate(Date issueDate) {
			this.issueDate = issueDate;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Date getDueDate() {
			return dueDate;
		}
		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}
		
		  public Books getBooks() { return books; } public void
		  setBooks(Books books) { this.books = books; 
		  } 
			
			  public Users getUsers() { return users; } public void setUsers(Users users) {
			  this.users = users; }
			 
		 
	}


