package com.chappal.foot.model;

import java.io.Serializable;

public class BuyNow implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDetail userDetail;
	private ShippingAddress shippingAddress;
	private BillingAddress billingAddress;
	private CartItems cartItems;
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public CartItems getCartItems() {
		return cartItems;
	}
	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}
	
}
