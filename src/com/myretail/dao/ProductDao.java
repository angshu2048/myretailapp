package com.myretail.dao;

import java.util.List;

import com.myretail.domain.*;

public interface ProductDao {

	public List<Product> findAllProducts();

	public List<Product> findAllProductsInStock();

	public List<Product> findAllProductsOutOfStock();

	public List<Product> searchProductById(String productId);

	public void add(Product product);

}
