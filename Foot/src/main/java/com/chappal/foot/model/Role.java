package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role 
{
	@Id
	private int role_Id;
	private int role_Name;
	
	public int getRole_Id() {
		return role_Id;
	}
	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}
	public int getRole_Name() {
		return role_Name;
	}
	public void setRole_Name(int role_Name) {
		this.role_Name = role_Name;
	}
}
