package com.niit.stop2shop.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.stop2shop.daointerface.CategoryDAO;
import com.niit.stop2shop.entity.Category;



public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		

		category = (Category) context.getBean("category");

	}

	@Ignore
	@Test
	public void createCategoryTestCase() {
		category.setId("1");
		category.setName("Mobile");
		category.setDescription("Mobiles with stock android");

		boolean flag = categoryDAO.save(category);

		assertEquals("createCategoryTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateCategoryTestCase() {
		category.setId("CATG1");
		category.setName("Dental Medicine");
		category.setDescription("for tooth pain");

		boolean flag = categoryDAO.update(category);

		assertEquals("updateCategoryTestCase", true, flag);

	}

	@Ignore
	@Test
	public void deleteCategoryTestCase() {
		category.setName("Dental Medicine");
		boolean flag = categoryDAO.delete(category.getName());

		assertEquals("deleteCategoryTestCase", true, flag);

	}

	@Ignore
	@Test
	public void listAllCategoryTestCase() {
		int actualSize = categoryDAO.list().size();
		assertEquals(6, actualSize);
	}

}
