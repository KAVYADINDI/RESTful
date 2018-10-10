package com.capgemini.customerapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.exceptions.AuthenticationFailedException;
import com.capgemini.customerapp.exceptions.CustomerAlreadyRegisteredException;
import com.capgemini.customerapp.exceptions.CustomerNotFoundException;
import com.capgemini.customerapp.repository.CustomerRepository;
import com.capgemini.customerapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer authenticate(Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if (optionalCustomer.isPresent()) {
			Customer cust = optionalCustomer.get();
			if (customer.getCustomerId() == cust.getCustomerId()) {
				if (cust.getCustomerPassword().equals(customer.getCustomerPassword())) {
					return customerRepository.findById(customer.getCustomerId()).get();
				}
				throw new AuthenticationFailedException("Username password not match");
			}
		}
		throw new CustomerNotFoundException("Customer does not exists");
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	@Override
	public Customer findCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent())
			return optionalCustomer.get();
		throw new CustomerNotFoundException("Customer does not exists");
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Optional<Customer> customerFromDb = customerRepository.findById(customer.getCustomerId());
		if (!customerFromDb.isPresent()) {
			return customerRepository.save(customer);
		}
		throw new CustomerAlreadyRegisteredException("Customer Already present with id "+ customer.getCustomerId());
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}
}
