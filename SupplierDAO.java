package com.niit.DAO;

import java.util.List;

import com.niit.Model.Supplier;

public interface SupplierDAO {
	
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSupplier();
	
}
