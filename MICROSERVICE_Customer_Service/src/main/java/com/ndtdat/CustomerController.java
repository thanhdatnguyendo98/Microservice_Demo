package com.ndtdat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	private OrderClient orderClient;

	public CustomerController(OrderClient orderClient) {
		this.orderClient = orderClient;
	}
	
	

	@GetMapping
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		return customerOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/{id}/orders")
	public Object getOrdersForCustomer(@PathVariable(value="id") int  id) {
		return orderClient.getOrdersForCustomer(id);
	}
}
