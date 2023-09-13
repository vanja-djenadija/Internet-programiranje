package org.unibl.etf.ip.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unibl.etf.ip.entities.Product;
import org.unibl.etf.ip.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	public @ResponseBody List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping("/{productCode}")
	public @ResponseBody List<Map.Entry<String, List<Product>>> getAllByProductCode(@PathVariable String productCode) {
		return service.getAllByProductCodeGroupedByProductLine(productCode);
	}
}
