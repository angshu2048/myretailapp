package com.myretail.services;

import java.util.List;

import com.myretail.domain.Product;

public interface ProductService {
	public List<Product> findAllProducts();
	public List<Product> findAllProductsInStock();
	public List<Product> findAllProductsOutOfStock();
	public List<Product> searchProductById(String productId);
	public void add(Product product);
}
