package com.entites;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue
	private int adminId;
	
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 5, max = 16, message = "Enter Valid Password ")
	private String adminPassword;
	
	@Column(name = "adminName", length = 40, nullable = false)
	private String adminName;	
	
	  @OneToMany(cascade=CascadeType.ALL)	  
	  private List<Books> books;
	  
	  @OneToMany(cascade=CascadeType.ALL)
	 private List<BooksOrder> booksorder;
	  
	  @OneToMany(cascade=CascadeType.ALL)
	  private List<DamagedBooks> damagedbooks;
	  @OneToMany(cascade=CascadeType.ALL)
	  private List<Users> users;
		
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/*
	 * public List<Books> getBooks() { return books; }
	 * 
	 * public void setBooks(List<Books> books) { this.books = books; }
	 */

	

}
