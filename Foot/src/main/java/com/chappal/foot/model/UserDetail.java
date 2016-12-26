package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserDetail 
{
	@Id
	private int user_Id;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]+")
	private String first_Name;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]+")
	private String last_Name;
	@Email
	private String email_Id;
	@NotEmpty
	@Pattern(regexp="[0-9]+")
	private String contact_Number;
	
	@OneToOne
	@JoinColumn(name="user_Id", nullable=false, insertable=false,updatable=false)
	private User user;

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getContact_Number() {
		return contact_Number;
	}

	public void setContact_Number(String contact_Number) {
		this.contact_Number = contact_Number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
