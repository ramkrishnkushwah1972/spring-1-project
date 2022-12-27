package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.Office;
import com.shopping.cart.app.repository.OfficeRepository;

@SpringBootTest
class OfficeServiceTest {

	@Autowired
	OfficeService officeService;

	@MockBean
	OfficeRepository officeRepository;

	@Test
	void testFindById() {
		Office office = new Office();

		office.setOfficeCode(1);
		office.setAddressLine1("Bhopal");
		office.setCity("Jhansi");
		office.setState("UP");
		office.setCountry("India");
		office.setPostalCode("280483");

		Mockito.when(officeRepository.save(office)).thenReturn(office);
		assertThat(officeService.findById(1L)).isNotNull();
	}

	@Test
	void testSave() {
		Office office = new Office();

		office.setOfficeCode(3);
		office.setAddressLine1("Bhopal, Mp");
		office.setCity("Bhopal");
		office.setState("MP");
		office.setCountry("India");
		office.setPostalCode("364322");


		Mockito.when(officeRepository.save(office)).thenReturn(office);
		assertThat(officeService.save(office)).isEqualTo(office);
	}

	@Test
	void testDelete() {
		Office office = new Office();

		office.setOfficeCode(3);
		office.setAddressLine1("Bhopal, Mp");
		office.setCity("Bhopal");
		office.setState("MP");
		office.setCountry("India");
		office.setPostalCode("364322");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		officeService.delete(1L);
		assertThat(officeService.findById(1L)).
		isNotNull();

	}

	@Test
	void testFindAll() {
		Office office = new Office();

		office.setOfficeCode(5);
		office.setAddressLine1("Bhopal, Mp");
		office.setCity("Bhopal");
		office.setState("MP");
		office.setCountry("India");
		office.setPostalCode("364322");

		Mockito.when(officeRepository.save(office)).thenReturn(office);
		assertThat(officeService.findAll()).isNotNull();

	}

}
