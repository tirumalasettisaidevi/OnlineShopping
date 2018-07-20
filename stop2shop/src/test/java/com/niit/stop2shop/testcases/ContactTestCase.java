package com.niit.stop2shop.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.stop2shop.daointerface.ContactDAO;
import com.niit.stop2shop.entity.Contact;



public class ContactTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ContactDAO contactDAO;
	@Autowired
	static Contact contact;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		contactDAO = (ContactDAO) context.getBean("contactDAO");

		
		contact = (Contact) context.getBean("contact");

	}

	@Ignore
	@Test
	public void createContactTestCase() {
		contact.setName("Sanaya");
		contact.setEmail("sanaya15@gmail.com");
		contact.setContact("8194869957");
		contact.setMessage("Good work");

		boolean flag = contactDAO.save(contact);

		assertEquals("createContactTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateContactTestCase() {

		boolean flag = contactDAO.delete(2);

		assertEquals("updateContactTestCase", true, flag);

	}

	@Ignore
	@Test
	public void listAllContactTestCase() {
		int actualSize = contactDAO.list().size();
		assertEquals(1, actualSize);
	}

}
