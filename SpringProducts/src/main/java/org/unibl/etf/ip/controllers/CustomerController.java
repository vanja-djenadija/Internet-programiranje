package org.unibl.etf.ip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.entities.Customer;
import org.unibl.etf.ip.entities.requests.CustomerUpdateRequest;
import org.unibl.etf.ip.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	// d
	@GetMapping("/unemployed")
	public List<Customer> getAllUnemployed() {
		return service.getAllUnemployed();
	}

	// e
	@GetMapping("/{lastName}")
	public List<Customer> getAllByLastName(@PathVariable String lastName) {
		return service.getAllByLastName(lastName);
	}

	// f - kaskadno sa order
	@DeleteMapping
	public Integer delete() {
		return service.deleteAllAddressLine2Empty();
	}

	// g
	@PutMapping("/{customerNumber}")
	public Customer update(@RequestBody CustomerUpdateRequest request, @PathVariable Integer customerNumber) throws NotFoundException {
		return service.update(request, customerNumber);
	}
}
