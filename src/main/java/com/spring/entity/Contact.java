package com.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	@Id
	private int id;
	
	private int numberProduct;
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;
	
	private String status;
	@Column(name = "startDate", columnDefinition = "DATETIME")
	private Date startDate;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	public Contact() {
		
	}

	public Contact(int numberProduct, Product product, String status, Date startDate, User user) {
		super();
		this.numberProduct = numberProduct;
		this.product = product;
		this.status = status;
		this.startDate = startDate;
		this.user = user;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberProduct() {
		return numberProduct;
	}

	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
