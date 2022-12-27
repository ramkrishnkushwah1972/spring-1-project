package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.Customer;
import com.shopping.cart.app.repository.CustomerRepository;

@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	void testFindById() {

		Customer customer = new Customer();

		customer.setCustomerNumber(1);
		customer.setCustomerName("Raja");
		customer.setContactFirstName("Raja");
		customer.setContactLastName("Saini");
		customer.setCreditLimit(6000);
		customer.setState("MP");
		customer.setCountry("India");

		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.findById(1)).isNotNull();

	}

	@Test
	void testSave() {
		Customer customer = new Customer();

		customer.setCustomerNumber(2);
		customer.setCustomerName("Ravi");
		customer.setContactFirstName("Ravi");
		customer.setContactLastName("Yadav");
		customer.setCreditLimit(8000);
		customer.setState("Gujrat");
		customer.setCountry("Pakistan");

		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.save(customer)).isEqualTo(customer);
	}

	@Test
	void testDelete() {
		Customer customer = new Customer();

		customer.setCustomerNumber(4);
		customer.setCustomerName("Ravi");
		customer.setContactFirstName("Ravi");
		customer.setContactLastName("Yadav");
		customer.setCreditLimit(8000);
		customer.setState("UP");
		customer.setCountry("India");

		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		customerService.delete(1L);
		assertThat(customerService.findById(1L)).isEmpty();

	}

	@Test
	void testFindAll() {

		Customer customer = new Customer();

		customer.setCustomerNumber(4);
		customer.setCustomerName("Bhola Mishra");
		customer.setContactFirstName("Bhola");
		customer.setContactLastName("Mishra");
		customer.setCreditLimit(8000);
		customer.setState("UP");
		customer.setCity("Jhansi");
		customer.setCountry("India");
		
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.findAll()).isNotNull();
	}

	}
