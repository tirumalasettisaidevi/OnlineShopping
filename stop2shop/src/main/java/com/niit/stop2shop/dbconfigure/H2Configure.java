package com.niit.stop2shop.dbconfigure;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.stop2shop.entity.Address;
import com.niit.stop2shop.entity.Category;
import com.niit.stop2shop.entity.Contact;
import com.niit.stop2shop.entity.My_Cart;
import com.niit.stop2shop.entity.Product;
import com.niit.stop2shop.entity.Supplier;
import com.niit.stop2shop.entity.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class H2Configure 
{
		@Bean(name = "dataSource")
		public DataSource getH2DataSource() {

			DriverManagerDataSource dataSource = new DriverManagerDataSource();

			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test5");
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUsername("sai");
			dataSource.setPassword("sai");

			return dataSource;
		}

		
		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");
			
			return properties;
		}

		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.addAnnotatedClass(Address.class);
			sessionBuilder.addAnnotatedClass(Product.class);
			sessionBuilder.addAnnotatedClass(My_Cart.class);
			sessionBuilder.addAnnotatedClass(Contact.class);
			sessionBuilder.scanPackages("com");

			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			return transactionManager;
		}

	}



