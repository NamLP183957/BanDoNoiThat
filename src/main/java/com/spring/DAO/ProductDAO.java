package com.spring.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Image;
import com.spring.entity.Product;

@Repository(value = "productDAO")
public class ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
	}
	
	public Long getNumberProduct(String type) {
		Long number;
		
		Session session = sessionFactory.openSession();
		Query query;
		if(type.equals("all")) {
			query = session.createQuery("SELECT COUNT(p) FROM Product p");
		}
		else {
			query = session.createQuery("SELECT COUNT(p) FROM Product p WHERE p.type := type");
			query.setParameter("type", type);
		}
		
		number =  (Long) query.list().get(0);
		session.close();
		
		return number;
	}
	
	public List<Product> getProduct(String type) {
		Session session = sessionFactory.openSession();
		
		Query query;
		if(type.equals("all")) {
			query = session.createQuery("FROM Product p");
		}
		else {
			query = session.createQuery("FROM Product p WHERE p.type =: type");
			query.setParameter("type", type);
		}
		
		List results = query.list();
		
		List<Product> listProduct = query.list();
				
		session.close();
		
		return listProduct;
	}
	
	public Product getProductDetail(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Product product = session.get(Product.class, id);
		
		transaction.commit();
		session.close();
		
		return product;
	}
	
	public boolean updateProduct(int id, String name, String description, Long price, Long numberInWare, String style) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("UPDATE Product p SET p.name=:name, p.description=:description,"
				+ "p.price=:price, p.numberInWare =: numberInWare,"
				+ "p.style =: style WHERE p.id =: id");
		query.setParameter("name", name);
		query.setParameter("description", description);
		query.setParameter("price", price);
		query.setParameter("numberInWare", numberInWare);
		query.setParameter("style", style);
		query.setParameter("id", id);
		
		int rowCount = query.executeUpdate();
		transaction.commit();
		session.close();
		if(rowCount > 0) return true;
		else return false;
	}
	
	public void deleteProduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		session.remove(product);
		
		transaction.commit();
		session.close();
	}
	
	public void addImage(int id, Image image) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		product.addImage(image);
		session.persist(product);
		
		transaction.commit();
		session.close();
	}
	
	public Product getBestSell() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT p FROM Product p ORDER BY p.numberOfSell ASC").setMaxResults(1);
		List<Product> listProduct = query.list();
		
		session.close();
		
		return listProduct.get(0);
	}
}
