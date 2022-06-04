package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("FROM Customer order by lastName", Customer.class)
				.getResultList();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(getCustomerById(id));
	}

}
