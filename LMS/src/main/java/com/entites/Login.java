package com.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@Entity
	@Table(name="login")
	public class Login {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int loginid;
		
		@Column(name = "username", length = 100, nullable = false,unique = true)
		@NotNull(message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
		private String userName;
		
		@Column(name = "Password", length = 100, nullable = false,unique = true)
		@NotNull(message = "Password cannot be empty")
		@Size(min = 5, max = 16, message = "Enter Valid Password ")
		private String password;
		
		@OneToOne
		private Users users;
		 
		public int getLoginId()
		{
			return loginid;
		}
		public void setLoginId(int loginId) 
		{
			this.loginid = loginId;
		}

		public String getUserName()
		{
			return userName;
		}
		public void setUserName(String userName)
		{
			this.userName = userName;
		}
		
		public String getPassword() 
		{
			return password;
		}
		public void setPassword(String password)
		{
			this.password = password;
		}
		
		public Users getUsers() 
		{
			return users; 
		} 
		public void setUsers(Users users) 
		{
		  this.users = users;
		}
		 
		
		
	}

