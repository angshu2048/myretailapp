package com.myretail.domain;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class ProductTest {

	private Validator validator;

	@Before
	public void setup() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void verifyValidProduct() {
		Product product = new Product("551952175", "Nest Learning Thermostat - 2nd Generation", "Nest Labs",
				"Smart Thermostat", 2);
		Set<ConstraintViolation<Product>> violations = validator.validate(product);
		assertTrue(violations.isEmpty());
	}
}
