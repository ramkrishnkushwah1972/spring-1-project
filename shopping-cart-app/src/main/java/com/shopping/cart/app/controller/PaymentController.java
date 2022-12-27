package com.shopping.cart.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.app.exception.ResourceNotFoundException;
import com.shopping.cart.app.model.Payment;
import com.shopping.cart.app.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/create")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.save(payment);
	}

	@GetMapping
	public List<Payment> getAllPayment() {
		return paymentService.findAll();
	}

	// Find Payment By Customer Number
	@GetMapping("/customernumber/{customerNumber}")
	public List<Payment> findByCustomerNumber(@PathVariable long customerNumber) {
		return paymentService.findByCustomerNumber(customerNumber);
	}

	// Find All Payment By Amount in descending order
	@GetMapping("/descending")
	public List<Payment> findAllPaymentByAmount() {
		return paymentService.findAllPaymentByAmount();
	}

	// Find Payment By Payment Date
	@GetMapping("/bydate/{localDate}")
	public List<Payment> findByPaymentDate(@PathVariable LocalDate localDate) {
		return paymentService.findByPaymentDate(localDate);
	}

	// Find By Amount Less Than
	@GetMapping("/lessthan/{amount}")
	public List<Payment> findByAmountLessThan(@PathVariable double amount) {
		return paymentService.findByAmountLessThan(amount);
	}

	// Find By Amount Greater Than
	@GetMapping("/greaterthan/{amount}")
	public List<Payment> findByAmountGreaterThan(@PathVariable double amount) {
		return paymentService.findByAmountGreaterThan(amount);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable long id) throws ResourceNotFoundException {
		Payment payment = paymentService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id: " + id));
		return ResponseEntity.ok(payment);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable long id, @RequestBody Payment payment)
			throws ResourceNotFoundException {
		Payment updatePayment = paymentService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id: " + id));

		updatePayment.setPaymentLocalDate(payment.getPaymentLocalDate());
		updatePayment.setAmount(payment.getAmount());

		paymentService.save(updatePayment);

		return ResponseEntity.ok(updatePayment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePayment(@PathVariable long id) throws ResourceNotFoundException {

		Payment payment = paymentService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id: " + id));

		paymentService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}
