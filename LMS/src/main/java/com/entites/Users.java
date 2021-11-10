package com.entites;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue
	private int userid;

	@Column(name = "password", nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Password must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
	private String password;
	@Column(name = "firstname", nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")

	private String firstName;
	@Column(name = "lastname", nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")

	private String lastName;
	@Column(name = "mobileno", unique = true, nullable = false, length = 10)
	@Pattern(regexp = "^[6|7|8|9]{1}[0-9]{9}$")
	@Size(max = 10, message = "Contact number must be 10 numbers")
	private String mobileno;
	@Column(name = "email", unique = true, nullable = false, length = 25)
	@Pattern(regexp = "^[a-z0-9+_.-]+@[a-z0-9.-]+$")
	@Size(max = 25, message = "Email should have be valid")
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateofbirth;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date subscriptiondate;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date subexpiredate;
	@NotNull
	private String subscriptionstatus;
	@ManyToOne
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Date getSubscriptiondate() {
		return subscriptiondate;
	}

	public void setSubscriptiondate(Date subscriptiondate) {
		this.subscriptiondate = subscriptiondate;
	}

	public Date getSubexpiredate() {
		return subexpiredate;
	}

	public void setSubexpiredate(Date subexpiredate) {
		this.subexpiredate = subexpiredate;
	}

	public String getSubscriptionstatus() {
		return subscriptionstatus;
	}

	public void setSubscriptionstatus(String subscriptionstatus) {
		this.subscriptionstatus = subscriptionstatus;
	}

	
	}


	


