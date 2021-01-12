package com.niit.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDetailDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session factory "+sessionFactory);
		
	}
	
	public boolean insertOrderDetail(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateOrderDetail(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update CartItem set status = 'P' where username =: myusername");
		query.setParameter("myusername", username);
		int row_eff = query.executeUpdate();
		if (row_eff > 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

}
