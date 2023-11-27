package com.example.entities.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired(required=false)
	CustomerService customerService;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces="application/json")
	public List<Customer>getCustomers(){
		Customer.info("Request a http://localhost:PORT/customers(GET)");
		return customerService.findAllCustomers();
	}
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.GET, produces="application/json")
	public Optional<Customer>getCustomers(@PathVariable Long id){
		Customer.info("Request a http://localhost:PORT/customers/id(GET)");
		return customerService.findCustomerById(id);
	}
}
