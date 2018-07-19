package com.niit.stop2shop.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.stop2shop.daointerface.SupplierDAO;
import com.niit.stop2shop.entity.Supplier;



public class SupplierTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		
		supplier = (Supplier) context.getBean("supplier");

	}

	@Test
	public void createSupplierTestCase() {
		supplier.setId("Sup-1");
		supplier.setName("BigC");
		supplier.setAddress("Secunderabad");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateSupplierTestCase() {
		supplier.setId("SUPP1");
		supplier.setName("MI");
		supplier.setAddress("SRNagar");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}

	@Ignore
	@Test
	public void listAllSupplierTestCase() {
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
