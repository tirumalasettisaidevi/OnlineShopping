package com.niit.stop2shop.daointerface;

import java.util.List;

import com.niit.stop2shop.entity.Category;



public interface CategoryDAO {
	
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	
	public List<Category> list();
	
	public Category getCategoryById(String id);
	
	public boolean delete(String id);
	

	public Category getCategoryByName(String name);

}
