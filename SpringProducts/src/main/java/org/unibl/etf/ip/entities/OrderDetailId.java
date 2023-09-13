package org.unibl.etf.ip.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order;
	private String product;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
