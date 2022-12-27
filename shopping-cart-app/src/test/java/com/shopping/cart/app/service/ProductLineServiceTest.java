package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.ProductLine;
import com.shopping.cart.app.repository.ProductLineRepository;

@SpringBootTest
class ProductLineServiceTest {

	@Autowired
	private ProductLineService productLineService;

	@MockBean
	private ProductLineRepository productLineRepository;

	@Test
	void testFindById() {
		ProductLine productLine = new ProductLine();

		productLine.setProductLine(1L);
		productLine.setTextDescription(
				"iPhone is the best phone available in different model");
		productLine.setHtmlDescription("<ol><li> iPhone is most famous brand</li></ol>");
		productLine.setImage("iPhone1.img");

		Mockito.when(productLineRepository.save(productLine)).thenReturn(productLine);
		assertThat(productLineService.findById(1L)).isNotNull();
	}

	@Test
	void testSave() {
		ProductLine productLine = new ProductLine();

		productLine.setProductLine(1L);
		productLine.setTextDescription(
				"iPhone is the best phone available in different model");
		productLine.setHtmlDescription("<ol><li> iPhone is most famous brand</li></ol>");
		productLine.setImage("iPhone1.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		assertThat(productLineService.save(productLine)).
		isEqualTo(productLine);	

	}

	@Test
	void testFindAll() {
		ProductLine productLine = new ProductLine();

		productLine.setProductLine(1L);
		productLine.setTextDescription(
				"iPhone is the best phone available in different model");
		productLine.setHtmlDescription("<ol><li> iPhone is most famous brand</li></ol>");
		productLine.setImage("iPhone1.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		assertThat(productLineService.findAll()).
		isNotNull();

	}

	@Test
	void testDelete() {
		ProductLine productLine = new ProductLine();

		productLine.setProductLine(1L);
		productLine.setTextDescription(
				"iPhone is the best phone available in different model");
		productLine.setHtmlDescription("<ol><li> iPhone is most famous brand</li></ol>");
		productLine.setImage("iPhone1.img");

		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		productLineService.delete(1L);
		assertThat(productLineService.findById(1L)).
		isEmpty();
	}

}
