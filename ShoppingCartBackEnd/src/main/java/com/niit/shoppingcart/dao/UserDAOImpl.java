package com.niit.shoppingcart.dao;

import java.util.List; 

 import org.springframework.transaction.annotation.Transactional;

 import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;

@SuppressWarnings("deprecation")
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(User category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
			
	}

	@Transactional
	public void delete(String id) {
		User category = new User();
		category.setId(id);
		sessionFactory.getCurrentSession().delete(category);
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where id=" + "'"+ id +"'";
		
		@SuppressWarnings({"rawtypes"})
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({"unchecked"})
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) 
		          sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
	
	


}


