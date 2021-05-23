package com.spring.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "adminDAO")
public class AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public String getAdmin(String username) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT ad.password FROM Admin ad WHERE ad.username =: username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		String password = (String) query.uniqueResult();
		session.close();
		
		return password;
	}
}
