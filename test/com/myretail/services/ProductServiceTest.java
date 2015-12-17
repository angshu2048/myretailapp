package com.myretail.services;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myretail.domain.Product;
import com.myretail.services.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	private static boolean populated = false;

	private void checkDataSetup() {
		if (!populated) {

			productService.add(new Product("010001", "Milk", "Land O Lakes",
					"Full Cream Milk, 1 Gallon", 100));
			productService.add(new Product("020001", "Soda",
					"Coca Cola Company", "Regular, 2 Liter Bottle", 0));
			productService.add(new Product("030001", "Juice", "Land O Lakes",
					"Orange Juice, 1 Gallon ", 100));
			productService.add(new Product("040001", "Coffee", "Folgers",
					"Dark Roast Arabica, 64oz ", 100));
			productService.add(new Product("050001", "Butter", "Crystal",
					"Salted Butter 1 Lbs, 4 Stricks", 100));

			populated = true;
		}

	}

	@SuppressWarnings("deprecation")
	@Test
	public void findAllProducts() {
		checkDataSetup();

		List<Product> products = productService.findAllProducts();

		Assert.assertEquals(5, products.size());
	}

	@Test
	public void findAllProductsInStock() {
		checkDataSetup();

		List<Product> products = productService.findAllProductsInStock();

		Assert.assertEquals(4, products.size());

	}

	@Test
	public void findAllProductsOutOfStock() {
		checkDataSetup();

		List<Product> products = productService.findAllProductsOutOfStock();

		Assert.assertEquals(1, products.size());

	}

	@Test
	public void searchProductById() {
		checkDataSetup();

		List<Product> products = productService.searchProductById("010001");

		Assert.assertEquals(1, products.size());

	}

}
