package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session factory "+sessionFactory);
		
	}
	
	
	public boolean addProduct(Product product) {
		
		try 
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Product getProduct(int productId) {
	try {
			Session session = sessionFactory.getCurrentSession();
			Product product = (Product) session.get(Product.class, productId);
			session.close();
			return product;
	}
	catch(Exception e)
	{
		return null;
	}
		
	}

	public List<Product> listProducts() {
		try{
			Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Product");
		List <Product> listProducts = query.list();
		session.close();
		return listProducts;
		}
		catch(Exception e) {
			return null;
		}
	}

	public List<Product> listProductsByCategory(int categoryId) {
		try{
			Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Product where CategoryId:catid");
		query.setParameter("catid", categoryId);
		List <Product> listProducts = query.list();
		session.close();
		return listProducts;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
