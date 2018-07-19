package com.niit.stop2shop.daointerface;

import java.util.List;

import com.niit.stop2shop.entity.Contact;


public interface ContactDAO {
	
	
	public  boolean save(Contact contact);
	
	public boolean delete(int id);
	
	
	public List<Contact> list();
	
	
	
	public Contact getContactById(int id);
	
}
