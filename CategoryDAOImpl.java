package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session factory "+sessionFactory);
		
	}
	
	public boolean addCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategory(int categoryId) {
		try{
			Session session = sessionFactory.getCurrentSession();
		
		Category category = (Category) session.get(Category.class, categoryId);
		session.close();
		return category;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Category> listCategories() {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Category");
			List <Category> listCategories = query.list();
			session.close();
			return listCategories;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
}
