package org.unibl.etf.ip.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	// orderNumber, orderDate, requiredDate, shippedDate, status, comments,
	// customerNumber
	@Id
	@Column(name = "ordernumber")
	private Integer orderNumber;

	@Column(name="orderdate")
	private Date orderDate;
	
	@Column(name="requireddate")
	private Date requiredDate;
	
	@Column(name="shippeddate")
	private Date shippedDate;
	
	@Column(name="status")
	private String status;
	
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "customernumber")
	private Customer customer;

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// Other fields, getters, setters, etc.
	
}