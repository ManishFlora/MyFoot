package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class UserDetail 
{
	@Id
	private int userId;
	@NotEmpty(message="Field is Required")
	@Expose
	private String userName;
	@Pattern(regexp="(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$", message="Invalid Password Pattern")
	@Expose
	private String userPassword;
	@Pattern(regexp="[a-zA-Z]+", message="Invalid Name Format")
	@Expose
	private String firstName;
	@NotEmpty(message="Field is Required")
	@Expose
	private String lastName;
	@Pattern(regexp=".+@.+\\..+", message="Invalid EmailID")
	@Expose
	private String emailId;
	@Pattern(regexp="[0-9]+", message="Invalid Number Format")
	@Expose
	private String contactNumber;
	@Expose
	private int cartId;

	@OneToOne
	@JoinColumn(name="userId", nullable=false, insertable=false,updatable=false)
	private User user;

	@Expose
	@OneToOne
	@JoinColumn(name="cartId", nullable=false, insertable=false,updatable=false)
	private Cart cart;
	
	@Expose
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@Expose
	@OneToOne
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	

}
