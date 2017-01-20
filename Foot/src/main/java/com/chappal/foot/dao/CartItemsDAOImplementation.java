package com.chappal.foot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.CartItemsDAO;
import com.chappal.foot.model.CartItems;
import com.chappal.foot.model.ListOrderProducts;
import com.chappal.foot.model.ListProducts;
import com.chappal.foot.model.WishList;
import com.chappal.foot.service.ProductsServices;

@Repository
public class CartItemsDAOImplementation implements CartItemsDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductsServices productsServices;
	
	public void addCartItems(CartItems cartItems) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(cartItems);
		session.flush();
	}
	public int retriveCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems").getResultList();
		int count = cartList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "C0000" + count;
		}
		else if(count < 100)
		{
			id = "C000" + count;
		}
		else if(count < 1000)
		{
			id = "C00" + count;
		}
		else if(count < 10000)
		{
			id = "C0" + count;
		}
		else
		{
			id = "C" + count;
		}
		return id;
	}
	
	public CartItems cartItemsListById(String cartItemsId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems where cartItemsId = '" + cartItemsId + "'").getResultList();
		if(cartList.isEmpty() && cartList.size() == 0)
		{
			return null;
		}
		else
		{
			return cartList.get(0);
		}
	}
	
	public List<CartItems> cartItemsList(String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems where userId = '" + userId + "' and flag=false").getResultList();
		return cartList;
	}
	
	public List<ListOrderProducts> listOrderProducts(String userId,String cartId)
	{
		if(cartId == null)
		{
			return null;
		}
		else
		{	
			Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<CartItems> cartList = session.createQuery("from CartItems where userId = '" + userId + "' and flag=false").getResultList();
			List<ListOrderProducts> listOrderProducts = new ArrayList<ListOrderProducts>();
			int count = cartList.size();
			for(int i = 0;i < count;i++)
			{
				String productsId = cartList.get(i).getProductsId();
				listOrderProducts.add(productsServices.retriveOrderList(productsId,cartId));
			}
			return listOrderProducts;
		}
	}
	
	public int retriveListByNameCount(String productsName,String userId,String orderDetail)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from CartItems where productName = '" + productsName + "' and userId = '" + userId + "' and orderDetail = '" + orderDetail + "'").getResultList();
		return wishList.size();
	}
	
	public void updateFlag(String cartItemsId)
	{
		sessionFactory.getCurrentSession().createQuery("Update CartItems set flag = true where cartItemsId = '" + cartItemsId + "'").executeUpdate();
	}
	
	public void updateAllFlag(String cartId)
	{
		sessionFactory.getCurrentSession().createQuery("Update CartItems set flag = true where cartId = '" + cartId + "'").executeUpdate();
	}
	
	public CartItems retriveListByName(String productsName,String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> wishList = session.createQuery("from CartItems where productName = '" + productsName + "' and userId = '" + userId + "'").getResultList();
		if(wishList.isEmpty() && wishList.size() == 0)
		{
			return null;
		}
		else
		{
			return wishList.get(0);
		}
	}
	
	public void updateQuantity(String cartItemsId,int quantity)
	{
		sessionFactory.getCurrentSession().createQuery("Update CartItems set quantity = quantity + " + quantity + " where cartItemsId = '" + cartItemsId + "'").executeUpdate();
	}
	
	public void cartItemsDelete(String cartItemsId)
	{
		CartItems cartItemsDelete = new CartItems();
		cartItemsDelete.setCartItemsId(cartItemsId);
		sessionFactory.getCurrentSession().delete(cartItemsDelete);
	}
	
	public CartItems retriveByCartId(String cartId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems where cartId = '" + cartId + "'").getResultList();
		return cartList.get(0);
	}
}
