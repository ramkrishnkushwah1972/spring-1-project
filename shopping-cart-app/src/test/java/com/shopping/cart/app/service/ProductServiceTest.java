package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.shopping.cart.app.model.Product;
import com.shopping.cart.app.repository.ProductRepository;

@SpringBootTest
class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;

	@Test
	void testCreate() {
	Product product = new Product();
		
		product.setProductCode(2);
		product.setProductName("Leptop");
		product.setBuyPrice(45000);
		product.setProductDescription("This is latest leptop");
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertThat(productService.create(product)).isEqualTo(product);
		
	}

	@Test
	void testFindById() {
		
		Product product = new Product();
		
		product.setProductCode(3);
		product.setProductName("Headphone");
		product.setProductDescription("This is headphone");
		product.setQuantityInStock(5);
		product.setBuyPrice(155);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findById(3)).
		isNotNull();
	}

	@Test
	void testDeleteProduct() {
		
		Product product = new Product();
		product.setProductCode(2);
		product.setProductName("Leptop");
		product.setBuyPrice(45000);
		product.setProductDescription("This is latest leptop");
		
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		productService.deleteProduct(2L);
		assertThat(productService.findById(2)).
		isEmpty();	
	}

	@Test
	void testFindAll() {
		Product product = new Product();
		
		product.setProductCode(4);
		product.setProductName("Bottol");
		product.setProductScale("Steel bottol");
		product.setQuantityInStock(55);
		product.setBuyPrice(110);
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertThat(productService.findAll()).isNotNull();	
	}

	@Test
	void testFindAllByProductNameAndBuyPrice() {
		
		Product product = new Product();
		
		product.setProductCode(5);
		product.setProductName("Bag");
		product.setQuantityInStock(2);
		product.setBuyPrice(750);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findAllByProductNameAndBuyPrice("Bag", 750)).
		isNotNull();	
	}

	@Test
	void testFindByNameLike() {
		
		Product product = new Product();
		
		product.setProductCode(6);
		product.setProductName("Pen");
		product.setQuantityInStock(8);
		product.setBuyPrice(12);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findByNameLike("Pen")).
		isNotNull();	
	}

	@Test
	void testFindAllOrderByBuyPrice() {
		
		Product product = new Product();
		
		product.setProductCode(7);
		product.setProductName("Black Board");
		product.setQuantityInStock(18);
		product.setBuyPrice(550);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findAllOrderByBuyPrice()).
		isNotNull();
		
	}

	@Test
	void testFindByPriceLessThan() {
		Product product = new Product();
		
		product.setProductCode(8);
		product.setProductName("Pen");
		product.setQuantityInStock(8);
		product.setBuyPrice(12);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findByPriceLessThan(12)).
		isNotNull();	
	}

	@Test
	void testFindByPriceGreaterThan() {
		Product product = new Product();
		
		product.setProductCode(8);
		product.setProductName("Color Pen");
		product.setQuantityInStock(250);
		product.setBuyPrice(15);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findByPriceGreaterThan(12)).
		isNotNull();	
	}

	@Test
	void testFindByNameStartingWith() {
		Product product = new Product();
		
		product.setProductCode(11);
		product.setProductName("Copy");
		product.setQuantityInStock(80);
		product.setBuyPrice(20);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.findByNameLike("Copy")).
		isNotNull();
	}

	
}
