package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.Customer;

public interface ICustomerDAO {
	public List<Customer> getAllCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);
}
