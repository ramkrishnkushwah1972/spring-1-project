package com.shopping.cart.app.controller;

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
import com.shopping.cart.app.model.OrderDetail;
import com.shopping.cart.app.service.OrderDetailService;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

	@PostMapping("/create")
	public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.save(orderDetail);
	}

	@GetMapping
	public List<OrderDetail> getAllOrderDetail() {
		return orderDetailService.findAll();
	}

	// Find By ProductCode And QuantityOrdered(long productCode, int
	// quantityOrdered);
	@GetMapping("/{productCode}/{quantityOrdered}")
	public List<OrderDetail> findByProductCodeAndQuantityOrdered(@PathVariable long pc, @PathVariable int q) {

		return orderDetailService.findByProductCodeAndQuantityOrdered(pc, q);
	}

	// Find By PriceEach  
	@GetMapping("/{priceEach}")
	public List<OrderDetail> findByPriceEach(@PathVariable long priceEach) {

		return orderDetailService.findByPriceEach(priceEach);
	}

	// Find All OrderDetail OrderBy PriceEach  
	@GetMapping("/orderbyprice")
	public List<OrderDetail> findAllOrderDetailOrderByPriceEach() {

		return orderDetailService.findAllOrderDetailOrderByPriceEach();
	}
	
	// Find By QuantityOrdered LessThan
	@GetMapping("/lessthan/{quantity}")
	public List<OrderDetail> findByQuantityOrderedLessThan(@PathVariable int quantityOrdered) {

		return orderDetailService.findByQuantityOrderedLessThan(quantityOrdered);
	}
	
	// List<OrderDetail> findByQuantityOrderedGreaterThan(int quantityOrdered);
	@GetMapping("/greaterthan/{quantity}")
	public List<OrderDetail> findByQuantityOrderedGreaterThan(@PathVariable int quantityOrdered) {

		return orderDetailService.findByQuantityOrderedGreaterThan(quantityOrdered);
	}
	
	// List<OrderDetail> findByOrderLineNumber(int orderLineNumber);
	@GetMapping("/orderline/{orderLineNumber}")
	public List<OrderDetail> findByOrderLineNumber(@PathVariable int orderLineNumber) {

		return orderDetailService.findByOrderLineNumber(orderLineNumber);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable long id) throws ResourceNotFoundException {
		OrderDetail orderDetail = orderDetailService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderDetail not exist with id: " + id));
		return ResponseEntity.ok(orderDetail);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable long id, @RequestBody OrderDetail orderDetail)
			throws ResourceNotFoundException {
		OrderDetail updateOrderDetail = orderDetailService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderDetail not exist with id: " + id));

		updateOrderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered());
		updateOrderDetail.setPriceEach(orderDetail.getPriceEach());
		updateOrderDetail.setOrderLineNumber(orderDetail.getOrderLineNumber());

		orderDetailService.save(updateOrderDetail);

		return ResponseEntity.ok(updateOrderDetail);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteOrderDetail(@PathVariable long id) throws ResourceNotFoundException {

		OrderDetail orderDetail = orderDetailService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderDetail not exist with id: " + id));

		orderDetailService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
