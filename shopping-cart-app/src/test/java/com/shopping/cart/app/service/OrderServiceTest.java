package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.Order;
import com.shopping.cart.app.repository.OrderRepository;

@SpringBootTest
class OrderServiceTest {

	@Autowired
	private OrderService orderService;

	@MockBean
	private OrderRepository orderRepository;

	@Test
	void testFindById() {
		Order order = new Order();

		order.setOrderNumber(1);
		order.setStatus(1);
		order.setComments("Delivered");
		order.setOrderLocalDate(LocalDate.of(2022,12,15));
		order.setRequiredLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		assertThat(orderService.findById(1L)).
		isNotNull();
	}

	@Test
	void testSave() {
		Order order = new Order();

		order.setOrderNumber(1);
		order.setStatus(1);
		order.setComments("Delivered");
		order.setOrderLocalDate(LocalDate.of(2022,12,15));
		order.setRequiredLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		assertThat(orderService.save(order)).
		isEqualTo(order);
	}

	@Test
	void testDelete() {
		Order order = new Order();

		order.setOrderNumber(1);
		order.setStatus(1);
		order.setComments("Delivered");
		order.setOrderLocalDate(LocalDate.of(2022,12,15));
		order.setRequiredLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		orderService.delete(1L);
		assertThat(orderService.findById(1L)).
		isEmpty();
	}

	@Test
	void testFindAll() {
		Order order = new Order();

		order.setOrderNumber(1);
		order.setStatus(1);
		order.setComments("Delivered");
		order.setOrderLocalDate(LocalDate.of(2022,12,15));
		order.setRequiredLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertThat(orderService.findAll()).isNotNull();
	}

}
