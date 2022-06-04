package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.ICustomerDAO;
import com.se.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private ICustomerDAO dao;

	@Override
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return dao.getCustomerById(id);
	}

	@Override
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
	}
	
	
}
