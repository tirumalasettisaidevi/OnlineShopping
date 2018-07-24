package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.stop2shop.daointerface.CategoryDAO;
import com.niit.stop2shop.daointerface.ProductDAO;
import com.niit.stop2shop.daointerface.SupplierDAO;
import com.niit.stop2shop.daointerface.UserDAO;
import com.niit.stop2shop.entity.Category;
import com.niit.stop2shop.entity.Product;
import com.niit.stop2shop.entity.Supplier;
import com.niit.stop2shop.entity.User;



@Controller
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;

	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	

	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView("/Home");
		log.debug("Starting of the method login");
		
		log.info("You are login with id : "+id);
		if (userDAO.validate(id, password) == true) {
			log.debug("Valid credentials");
			user = userDAO.get(id);
			mv.addObject("message", "Welcome " + user.getName() + "!");

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);
			
			session.setAttribute("loggedInUserID", id);


			
			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("You are admin");
				mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "ROLE_ADMIN");

			} else {
				log.debug("You are a customer");
				mv.addObject("isAdmin", "false");
				session.setAttribute("role", "ROLE_USER");
				session.setAttribute("isUserLoggedIn", "true");
			}
		} else {
			log.debug("Invalid user");
			mv.addObject("message", "invalid credentials");
		}
		log.debug("Ending of the method login");
		return mv;

	}
	
	@RequestMapping("/Register")
	public ModelAndView register(@RequestParam("uEmail") String email, @RequestParam("uId") String id, @RequestParam("uPassword") String password, @RequestParam("uName") String name, @RequestParam("uCountry") String country, @RequestParam("uAddress") String address, @RequestParam("uContact") String contact) {

		ModelAndView mv = new ModelAndView("/Home");
		log.debug("Starting of the method register");
		log.debug("Assigning values");
		
		user.setEmail(email);
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setContact(contact);
		user.setCountry(country);
		user.setAddress(address);
		user.setRole("ROLE_USER");
		
		
		log.info("You are signing up with username : "+id);
		
		if (userDAO.save(user) == true) {
			log.debug("saving credentials");
			user = userDAO.get(id);
			mv.addObject("message", "Welcome " + user.getName() + "! Please Login to Continue");

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);
			

			
		} else {
			log.debug("Error");
			mv.addObject("message", "invalid credentials");
		}
		log.debug("Ending of the method login");
		return mv;

	}

}
