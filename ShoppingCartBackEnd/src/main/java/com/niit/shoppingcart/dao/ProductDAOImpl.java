package com.niit.shoppingcart.dao;

import java.util.List; 

 import org.springframework.transaction.annotation.Transactional;

 import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;

@SuppressWarnings("deprecation")
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Product category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
			
	}

	@Transactional
	public void delete(String id) {
		Product category = new Product();
		category.setId(id);
		sessionFactory.getCurrentSession().delete(category);
	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id=" + "'"+ id +"'";
		
		@SuppressWarnings({"rawtypes"})
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({"unchecked"})
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) 
		          sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}
	
	


}


