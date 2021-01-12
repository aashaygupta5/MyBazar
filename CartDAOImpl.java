package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.CartItem;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session factory "+sessionFactory);
		
	}

	public boolean addCartItem(CartItem cartItem) {
		
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public List<CartItem> showCartItems(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where username=: myusername and status=: 'NA'");
		query.setParameter("myusername", username);
		List<CartItem> listCartItems = (List<CartItem>)query.list();
		session.close();
		return listCartItems;
	}

	public CartItem getCartItem(int cartItemId) {
		
		Session session = sessionFactory.openSession();
		CartItem cartItem =(CartItem)session.get(CartItem.class, cartItemId);
		session.close();
		return cartItem;
		
	}
	
}
