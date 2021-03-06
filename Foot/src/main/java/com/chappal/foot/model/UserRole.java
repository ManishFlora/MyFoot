package com.chappal.foot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.chappal.foot.model.Role;
import com.chappal.foot.model.User;
import com.google.gson.annotations.Expose;

@Entity
public class UserRole implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String userId;
	@Expose
	private int roleId;
	
	@Expose
	@OneToOne
	@JoinColumn(name="userId",nullable=false,insertable=false,updatable=false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="roleId",nullable=false,insertable=false,updatable=false)
	private Role role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
