package org.unibl.etf.ip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.entities.Customer;
import org.unibl.etf.ip.entities.Order;
import org.unibl.etf.ip.entities.requests.CustomerUpdateRequest;
import org.unibl.etf.ip.repositories.CustomerRepository;
import org.unibl.etf.ip.repositories.OrderDetailsRepository;
import org.unibl.etf.ip.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	public List<Customer> getAllUnemployed() {
		return repo.findAllBySalesRepEmployeeNumber(null);
	}

	public List<Customer> getAllByLastName(String lastName) {
		return repo.findAllByContactLastName(lastName);
	}

	@Transactional
	public Integer deleteAllAddressLine2Empty() {
		List<Customer> customers = repo.findAllByAddressLine2(null);
		for (Customer c : customers) {
			List<Order> orders = c.getOrders();
			for (Order o : orders) {
				orderDetailsRepository.deleteByOrder_OrderNumber(o.getOrderNumber());
			}
			orderRepository.deleteAll(orders);
		}
		repo.deleteAll(customers);
		return customers.size();
	}

	public Customer update(CustomerUpdateRequest request, Integer customerNumber) throws NotFoundException {
		Customer customer = repo.findById(customerNumber).orElseThrow(NotFoundException::new);
		customer.setContactFirstName(request.getFirstName());
		customer.setContactLastName(request.getLastName());
		repo.saveAndFlush(customer);
		return customer;
	}

}
