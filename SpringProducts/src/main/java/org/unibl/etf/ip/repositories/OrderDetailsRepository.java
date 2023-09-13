package org.unibl.etf.ip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.entities.OrderDetailId;
import org.unibl.etf.ip.entities.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailId> {
	void deleteByOrder_OrderNumber(int orderNumber);
}
