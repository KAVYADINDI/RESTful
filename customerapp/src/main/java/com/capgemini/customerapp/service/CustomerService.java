package com.capgemini.customerapp.service;

import com.capgemini.customerapp.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public Customer authenticate(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer findCustomer(int customerId);

	public void deleteCustomer(int customerId);
}
