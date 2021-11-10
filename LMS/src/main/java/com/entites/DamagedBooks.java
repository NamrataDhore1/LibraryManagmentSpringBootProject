package com.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="damagedbooks")
public class DamagedBooks {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "quantity", nullable = false)
	@NotNull(message = "quantity Should Not Be Null")
	private int quantity;
	@Column(name = "description", length = 250, nullable = false)
	@NotNull(message = "description cannot be null")
	private String description;
	@OneToOne(cascade = CascadeType.MERGE)
	private Books books;

	@ManyToOne
	private Admin admin;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
