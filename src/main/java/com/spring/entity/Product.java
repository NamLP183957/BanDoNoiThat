package com.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String type;
	private Long price;
	private Long numberInWare;
	private Long numberOfSell;
	private String style;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
	private List<Image> images;
	public Product() {
		
	}

	public Product(String name, String description, String type, Long price, Long numberInWare, Long numberOfSell, String style,
			List<Image> images) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.price = price;
		this.numberInWare = numberInWare;
		this.numberOfSell = numberOfSell;
		this.style = style;
		this.images = images;
	}

	public Product(String name, String description, String type, Long price, Long numberInWare, Long numberOfSell,
			String style) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.price = price;
		this.numberInWare = numberInWare;
		this.numberOfSell = numberOfSell;
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getNumberInWare() {
		return numberInWare;
	}

	public void setNumberInWare(Long numberInWare) {
		this.numberInWare = numberInWare;
	}

	public Long getNumberOfSell() {
		return numberOfSell;
	}

	public void setNumberOfSell(Long numberOfSell) {
		this.numberOfSell = numberOfSell;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addImage(Image image) {
		this.images.add(image);
		image.setProduct(this);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", price="
				+ price + ", numberInWare=" + numberInWare + ", numberOfSell=" + numberOfSell + ", style=" + style
				+ "]";
	}
	
}
