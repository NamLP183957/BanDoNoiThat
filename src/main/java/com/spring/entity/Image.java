package com.spring.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "content", columnDefinition = "LONGBLOB not null")
	private byte[] content;
	private String base64Image;
	
	@ManyToOne()
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	public Image() {
		
	}	

	public Image(byte[] content, String base64Image, Product product) {
		super();
		this.content = content;
		this.base64Image = base64Image;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", content=" + Arrays.toString(content) + "]";
	}
	
}
