package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.niit.Model.Supplier;


public class SupplierDAOImpl implements SupplierDAO{
	
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) {
		try 
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean updateSupplier(Supplier supplier) {
		try 
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try 
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		Session session = sessionFactory.openSession();
		Supplier supplier =(Supplier)session.get(Supplier.class, supplierId);
		session.close();
		return supplier;
	}

	public List<Supplier> listSupplier() {
		try{
			Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Supplier");
		List <Supplier> listSupplier = query.list();
		session.close();
		return listSupplier;
		}
		catch(Exception e) {
			return null;
		}
	}
	

}
