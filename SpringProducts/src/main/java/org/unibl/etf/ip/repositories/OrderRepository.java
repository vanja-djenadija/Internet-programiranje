package org.unibl.etf.ip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
