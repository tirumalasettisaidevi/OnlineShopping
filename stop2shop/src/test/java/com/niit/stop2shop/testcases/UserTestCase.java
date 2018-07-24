package com.niit.stop2shop.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.stop2shop.daointerface.UserDAO;
import com.niit.stop2shop.entity.User;



public class UserTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}
	@Ignore
	@Test
	public void createUserTestCase() {
		user.setEmail("sanaya15@gmail.com");
		user.setId("User1");
		user.setName("Sanaya");
		user.setPassword("password");
		user.setCountry("India");
		user.setAddress("Hyderabad");
		user.setRole("ROLE_USER");
		user.setContact("8194869957");
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}
	//@Ignore
	@Test
	public void updateUserTestCase() {
		user.setEmail("sanaya15@gmail.com");
		user.setId("User1");
		user.setName("Sanaya");
		user.setPassword("password");
		user.setCountry("India");
		user.setAddress("Hyderabad");
		user.setRole("ROLE_ADMIN");
		user.setContact("9490167876");
		boolean flag = userDAO.update(user);

		assertEquals("updateUserTestCase", true, flag);

	}

	@Ignore
	@Test
	public void validateUserTestCase() {

		boolean flag = userDAO.validate("User1", "password");
		assertEquals(true, flag);

	}

	@Ignore
	@Test
	public void listAllUserTestCase() {
		int actualSize = userDAO.list().size();
		assertEquals(1, actualSize);
	}

}
