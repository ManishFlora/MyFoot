package com.chappal.foot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity
public class WishList implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Expose
	private String wishListId;
	@Expose
	private String cartId;
	@Expose
	private String productsId;
	@Expose
	private String userId;
	@Expose
	private int quantity;
	@Expose
	private int amount;
	@Expose
	private String productsName;
	@Expose
	private boolean flag;
	
	@ManyToOne
	@JoinColumn(name="cartId",nullable=false,insertable=false, updatable=false)
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="productsId" ,nullable=false,insertable=false, updatable=false)
	private Products product;
	
	@ManyToOne
	@JoinColumn(name="userId" ,nullable=false,insertable=false, updatable=false)
	private UserDetail userDetail;

	public String getWishListId() {
		return wishListId;
	}

	public void setWishListId(String wishListId) {
		this.wishListId = wishListId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getProductsId() {
		return productsId;
	}

	public void setProductsId(String productsId) {
		this.productsId = productsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
}
