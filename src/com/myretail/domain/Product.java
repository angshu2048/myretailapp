package com.myretail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	private String productId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "QUANTITY")
	private Integer quantity;

	public Product() {
		super();
	}

	public Product(String productId, String name, String manufacturer,
			String description, Integer quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public String getDescription() {
		return description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
