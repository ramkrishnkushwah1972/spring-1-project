package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.OrderDetail;
import com.shopping.cart.app.repository.OrderDetailRepository;

@SpringBootTest
class OrderDetailServiceTest {

	@Autowired
	private OrderDetailService orderDetailService;

	@MockBean
	private OrderDetailRepository orderDetailRepository;

	@Test
	void testFindById() {
		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setOrderNumber(1);
		orderDetail.setOrderLineNumber(3);
		orderDetail.setPriceEach(110);
		orderDetail.setQuantityOrdered(100);

		Mockito.when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);
		assertThat(orderDetailService.findById(1L)).isNotNull();
	}

	@Test
	void testSave() {

		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setOrderNumber(1);
		orderDetail.setOrderLineNumber(4);
		orderDetail.setPriceEach(56);
		orderDetail.setQuantityOrdered(250);

		Mockito.when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);
		assertThat(orderDetailService.save(orderDetail)).isEqualTo(orderDetail);
	}

	@Test
	void testDelete() {
		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setOrderNumber(1);
		orderDetail.setOrderLineNumber(3);
		orderDetail.setPriceEach(14.20);
		orderDetail.setQuantityOrdered(110);

		Mockito.when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);
		orderDetailService.delete(1L);
		assertThat(orderDetailService.findById(1L)).isEmpty();
	}

	@Test
	void testFindAll() {
		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setOrderNumber(1);
		orderDetail.setOrderLineNumber(3);
		orderDetail.setPriceEach(14.20);
		orderDetail.setQuantityOrdered(110);

		Mockito.when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);
		assertThat(orderDetailService.findAll()).isNotNull();
	}

}
