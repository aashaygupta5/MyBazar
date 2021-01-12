package com.niit.DAO;

import java.util.List;

import com.niit.Model.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	
	public Category getCategory(int CategoryId);
	public List<Category> listCategories();
	
}
