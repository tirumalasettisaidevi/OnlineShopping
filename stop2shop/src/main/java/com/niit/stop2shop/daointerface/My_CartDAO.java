package com.niit.stop2shop.daointerface;

import java.util.List;

import com.niit.stop2shop.entity.My_Cart;


public interface My_CartDAO {
	
	public boolean save(My_Cart my_Cart);

	public boolean update(My_Cart my_Cart);
	
	public boolean updateQuant(int quant,String user_id);
	
	public boolean updatePrice(Double price,String user_id);
	
	public boolean delete(int id);
	
	public boolean deleteAllProductsInCart(String user_id);

	public List<My_Cart> list(String userID);
	
	public double getTotalAmount(String userID);
	
	public My_Cart getCartById(int id);

}
