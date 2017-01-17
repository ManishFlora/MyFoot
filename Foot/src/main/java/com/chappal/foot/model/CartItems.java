package com.chappal.foot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity
public class CartItems implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Expose
	private String cartItemsId;
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
	private String productName;
	@Expose
	private boolean flag;
	@Expose
	private Date orderDate;
	@Expose
	private String orderDetail;
	
	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	@ManyToOne
	@JoinColumn(name="cartId",nullable=false,insertable=false, updatable=false)
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="productsId",nullable=false,insertable=false, updatable=false)
	private Products products;

	public String getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(String cartItemsId) {
		this.cartItemsId = cartItemsId;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
}