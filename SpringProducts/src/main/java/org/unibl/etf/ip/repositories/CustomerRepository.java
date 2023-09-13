package org.unibl.etf.ip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findAllBySalesRepEmployeeNumber(Integer salesRepEmployeeNumber);
	List<Customer> findAllByContactLastName(String contactLasName);
	List<Customer> findAllByAddressLine2(String addressLine2);
}

