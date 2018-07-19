package com.niit.stop2shop.daointerface;

import java.util.List;

import com.niit.stop2shop.entity.User;


public interface UserDAO {
	
	
	
	
	public  boolean save(User user);
	
	
	public boolean update(User user);
	
	
	public boolean validate(String id, String password);
	
	
	
	public List<User> list();
	
	
	
	public User get(String id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
