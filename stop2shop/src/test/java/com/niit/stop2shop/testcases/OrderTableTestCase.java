package com.niit.stop2shop.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.stop2shop.daointerface.OrderTableDAO;
import com.niit.stop2shop.entity.OrderTable;



public class OrderTableTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static OrderTable orderTable;
	
	@Autowired
	static OrderTableDAO orderTableDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		orderTableDAO =  (OrderTableDAO) context.getBean("orderTableDAO");
		
		
		orderTable = (OrderTable)context.getBean("orderTable");
		
	}
	
	
	@Ignore
	@Test
	public void createOrderTableTestCase(){
		orderTable.setId(1);
		orderTable.setUser_id("User1");
		orderTable.setStatus("N");
		orderTable.setDate_ordered(new java.util.Date());
		boolean flag = orderTableDAO.save(orderTable);
		assertEquals("createOrderTableTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void listTestCase(){
		int orderedSize = orderTableDAO.list("User1").size();
		assertEquals(1, orderedSize);
	}

}
