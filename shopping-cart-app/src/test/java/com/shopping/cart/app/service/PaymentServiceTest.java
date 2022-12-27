package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.Payment;
import com.shopping.cart.app.repository.PaymentRepository;

@SpringBootTest
class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;

	@MockBean
	private PaymentRepository paymentRepository;

	@Test
	void testFindById() {
		Payment payment = new Payment();

		payment.setAmount(10000);
		payment.setPaymentLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		assertThat(paymentService.findById(1L)).isNotNull();
	}

	@Test
	void testSave() {
		Payment payment = new Payment();

		payment.setAmount(10000);
		payment.setPaymentLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		assertThat(paymentService.save(payment)).
		isEqualTo(payment);
	}

	@Test
	void testDelete() {
		Payment payment = new Payment();

		payment.setAmount(10000);
		payment.setPaymentLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		paymentService.delete(1L);
		assertThat(paymentService.findById(1L)).
		isEmpty();
	}

	@Test
	void testFindAll() {
		Payment payment = new Payment();

		payment.setAmount(10000);
		payment.setPaymentLocalDate(LocalDate.of(2022,12,16));

		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		assertThat(paymentService.findAll()).
		isNotNull();
	}

}
