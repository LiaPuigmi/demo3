package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers() {
		Customer.info("Request a http://localhost:PORT/customers(GET)");
		return customerService.findAllCustomers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Customer> getCustomers(@PathVariable Long id) {
		Customer.info("Request a http://localhost:PORT/customers/id(GET)");
		return customerService.findCustomerById(id);
	}

	@PutMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer.info("Request a http://localhost:PORT/customers/add(PUT)");
		return customerService.addCustomer(customer);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		Customer.info("Request a http://localhost:PORT/customers/delete/id(DELETE)");

		customerService.deleteCustomer(id);
	}

	@PatchMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer.info("Request a http://localhost:PORT/customers/update(PATCH)");
		return customerService.updateCustomer(customer);
	}

}
