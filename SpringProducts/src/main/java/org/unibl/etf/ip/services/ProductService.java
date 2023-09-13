package org.unibl.etf.ip.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.entities.Product;
import org.unibl.etf.ip.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Map.Entry<String, List<Product>>> getAllByProductCodeGroupedByProductLine(String productCode) {
		List<Product> products = repo.findByProductCode(productCode);
		Map<String, List<Product>> grouped = products.stream().collect(Collectors.groupingBy(Product::getProductLine));
		return grouped.entrySet().stream().toList();
	}

	public List<Product> getAll() {
		return repo.findAll();
	}
}
