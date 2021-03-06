package com.myretail.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import com.myretail.domain.Product;
import com.myretail.services.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@WebAppConfiguration
public class LookupControllerTest {

	@InjectMocks
	LookupController controller;

	@Mock
	ProductService mockProductService;

	@Mock
	View mockView;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
	}

	@Test
	public void getAllProducts() throws Exception {
		List<Product> expectedProduct = Arrays.asList(new Product());
		when(mockProductService.findAllProducts()).thenReturn(expectedProduct);
		mockMvc.perform(get("/findAll")).andExpect(status().isOk())
				.andExpect(model().attribute("products", expectedProduct)).andExpect(view().name("index")).andReturn();
	}

	@Test
	public void getAllProductsInStock() throws Exception {
		List<Product> expectedProduct = Arrays.asList(new Product());
		when(mockProductService.findAllProductsInStock()).thenReturn(expectedProduct);
		mockMvc.perform(get("/findAllProductsInStock")).andExpect(status().isOk())
				.andExpect(model().attribute("products", expectedProduct)).andExpect(view().name("index"));
	}

	@Test
	public void getAllProductsOutOfStock() throws Exception {
		List<Product> expectedProduct = Arrays.asList(new Product());
		when(mockProductService.findAllProductsOutOfStock()).thenReturn(expectedProduct);
		mockMvc.perform(get("/findAllProductsOutOfStock")).andExpect(status().isOk())
				.andExpect(model().attribute("products", expectedProduct)).andExpect(view().name("index"));
	}

	@Test
	public void findProductById() throws Exception {
		mockMvc.perform(post("/searchproduct").contentType(MediaType.TEXT_PLAIN).param("productId", "12345"))
				.andExpect(status().isOk());
	}
}
