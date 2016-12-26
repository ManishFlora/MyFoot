package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.chappal.foot.model.Role;
import com.chappal.foot.model.User;

@Entity
public class UserRole 
{
	@Id
	private int user_Id;
	private int role_Id;
	
	@OneToOne
	@JoinColumn(name="user_Id",nullable=false,insertable=false,updatable=false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="role_Id",nullable=false,insertable=false,updatable=false)
	private Role role;
	
	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}
