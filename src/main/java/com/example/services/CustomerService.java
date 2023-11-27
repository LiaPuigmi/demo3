package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findCustomerById(Long id){
		Optional<Customer> customer=customerRepository.findById(id);
		return customer;
	}
	
}
