package com.niit.stop2shop.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.stop2shop.daointerface.ProductDAO;
import com.niit.stop2shop.entity.Product;



public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		product = (Product)context.getBean("product");
		
	}
	@Ignore
	@Test
	public void createProductTestCase()
	{
		
		product.setId("1");
		product.setCategory_id("1");
		product.setDescription("4GB RAM|64GB ROM,AndroidOne Smartphone");
		product.setName("Mi A1");
		product.setPrice(15000);
		product.setQuantity(4);
		product.setSupplier_id("Sup-1");
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	@Ignore
	@Test
	public void updateProductTestCase()
	{
		product.setId("1");
		product.setName("Mi A1");
		product.setDescription("4GB RAM|64GB ROM,AndroidOne Smartphone");
		product.setCategory_id("1");
		product.setPrice(15000);
		product.setSupplier_id("Sup-1");
		product.setQuantity(2);
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("update Product TestCase",true,flag);
	}
	@Ignore
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(1, actualSize);
	} 
}
