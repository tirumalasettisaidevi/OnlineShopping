package com.niit.stop2shop.daoimplement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.stop2shop.daointerface.ProductDAO;
import com.niit.stop2shop.entity.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product").list();

	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Product getProductById(String id) {
		
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public Product getProductByName(String name) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = ?")
				.setString(0, name).uniqueResult();
	}

	public List<Product> getAllProductsByCategoryId(String categoryId) {
		
		String hql = "from Product where category_Id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, categoryId);
		return query.list();

	}

	public List<Product> getAllProductsBySupplierId(String supplierId) {
		return sessionFactory.getCurrentSession().createQuery("from Product where supplier_Id = ?").setString(0, supplierId).list();
	}
}
