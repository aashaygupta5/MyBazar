package com.niit.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session factory "+sessionFactory);
	}
	
	public boolean registerUserDetail(UserDetail userDetail) {
				
		try 
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUserDetail(UserDetail userDetail) {
		try 
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUserDetail(UserDetail userDetail) {
		try 
		{
			sessionFactory.getCurrentSession().delete(userDetail);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public UserDetail getUserDetail(String username) {
		try {
			Session session = sessionFactory.getCurrentSession();
			UserDetail userDetail = (UserDetail) session.get(UserDetail.class, username);
			session.close();
			return userDetail;
	}
	catch(Exception e)
	{
		return null;
	}
	}

}
