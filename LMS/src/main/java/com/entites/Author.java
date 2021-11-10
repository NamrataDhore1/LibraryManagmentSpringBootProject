package com.entites;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
	@Entity
	@Table(name = "authors")
	public class Author {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int authorId;
		@Column(name = "firstname", length = 100, nullable = false,unique = true)
		@NotNull(message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
		private String firstName;
		@Column(name = "lastname", length = 100, nullable = false,unique = true)
		@NotNull(message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
		private String lastName;
	    @Column(name = "email", unique = true, nullable = false, length = 25)
	    @Pattern(regexp = "^[a-z0-9+_.-]+@[a-z0-9.-]+$")
		@Size(max = 25, message = "Email should have be valid")		
		private String email;
		@Column(name = "contactno", unique = true, nullable = false, length = 10)
		@Pattern(regexp = "^[6|7|8|9]{1}[0-9]{9}$")
		@Size(max = 10, message = "Contact number must be 10 numbers")
		private String contactno;
		
		  @OneToMany(cascade=CascadeType.ALL)	 
		  private List<Books> books;
		 
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContactno() {
			return contactno;
		}
		public void setContactno(String contactno) {
			this.contactno = contactno;
		}
		
		/*
		 * public List<Books> getBooks() { return books; } public void
		 * setBooks(List<Books> books) { this.books = books; }
		 */
		
		@Override
		public String toString() {
			return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
					+ email + ", contactno=" + contactno + ", books=" + "books" + "]";
		}
		
		
		


}
