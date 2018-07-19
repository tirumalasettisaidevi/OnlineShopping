package com.niit.stop2shop.daointerface;

import java.util.List;

import com.niit.stop2shop.entity.OrderTable;



public interface OrderTableDAO {
	
	public boolean save(OrderTable orderTable);
	public List<OrderTable> list(String userId);

}
