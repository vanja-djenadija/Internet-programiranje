package org.unibl.etf.ip.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.entities.Product;
import org.unibl.etf.ip.entities.requests.RangeRequest;
import org.unibl.etf.ip.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}

	// a
	@GetMapping("/{productCode}")
	public List<Map.Entry<String, List<Product>>> getAllByProductCode(@PathVariable String productCode) {
		return service.getAllByProductCodeGroupedByProductLine(productCode);
	}

	// b
	@GetMapping("/price/{buyPrice}")
	public List<Product> getAllByBuyPriceGreaterEqual(@PathVariable Double buyPrice) {
		return service.getAllByBuyPriceGreaterEqual(buyPrice);
	}

	// c
	@PostMapping("/quantity")
	public List<Product> getAllQuantityBetween(@RequestBody RangeRequest request) {
		return service.getAllQuantityBetween(request);
	}
}
