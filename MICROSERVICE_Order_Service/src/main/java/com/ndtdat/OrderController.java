package com.ndtdat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	/*
	 * @GetMapping("/orders") public @ResponseBody Iterable<Order> getAllOrders() {
	 * return orderRepository.findAll(); }
	 */

	/*
	 * @GetMapping("ot/{customerid}") public ResponseEntity<List<Order>>
	 * findBycustomerid(@PathVariable(value="customerid") Integer customerid) { try
	 * { List<Order> orders = orderRepository.findBycustomerid(customerid);
	 * 
	 * if (orders.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 * return new ResponseEntity<>(orders, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	@GetMapping
	public ResponseEntity<List<Order>> findBycustomerid(@RequestParam(required = false) Integer customerid) {
		try {
			List<Order> orders = orderRepository.findBycustomerid(customerid);

			if (orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("{id}")
	public Optional<Order> getCustomerById(@PathVariable Long id) {
		return orderRepository.findById(id);
	}
}
