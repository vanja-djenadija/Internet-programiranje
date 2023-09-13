package org.unibl.etf.ip.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailId.class)
public class OrderDetails {

	@Id
	@ManyToOne
	@JoinColumn(name = "ordernumber", referencedColumnName = "ordernumber", insertable = false, updatable = false)
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "productcode", referencedColumnName = "productcode", insertable = false, updatable = false)
	private Product product;

	@Column(name = "quantityordered")
	private int quantityOrdered;

	@Column(name = "priceeach")
	private Double priceEach;

	@Column(name = "orderlinenumber")
	private short orderLineNumber;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(Double priceEach) {
		this.priceEach = priceEach;
	}

	public short getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

}
