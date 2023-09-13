package org.unibl.etf.ip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findAllByProductCode(String productCode);
	List<Product> findAllByBuyPriceGreaterThanEqual(Double buyPrice);
	List<Product> findAllByQuantityInStockBetween(Integer start, Integer end);
}
