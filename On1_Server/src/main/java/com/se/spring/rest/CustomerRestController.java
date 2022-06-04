package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.Customer;
import com.se.spring.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomes(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		
		if (customer == null)
			throw new CustomerNotFoundExc("Customer id not found - " + customerId);
		
		return customer;
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	
	@DeleteMapping("/{customerId}")
	public String addCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		
		if (customer == null)
			throw new CustomerNotFoundExc("Customer id not found - " + customerId);
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
}
