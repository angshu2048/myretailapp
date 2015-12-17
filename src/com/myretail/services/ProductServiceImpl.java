package com.myretail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.dao.ProductDao;
import com.myretail.domain.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}

	@Override
	public List<Product> findAllProductsInStock() {
		return productDao.findAllProductsInStock();
	}

	@Override
	public List<Product> searchProductById(String productId) {
		
		return productDao.searchProductById(productId);
	}

	@Override
	public void add(Product product) {
		productDao.add(product);

	}

	@Override
	public List<Product> findAllProductsOutOfStock() {
		return productDao.findAllProductsOutOfStock();
	}

}
