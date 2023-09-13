package org.unibl.etf.ip.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "productcode")
	private String productCode;
	@Column(name = "productname")
	private String productName;
	@Column(name = "productline")
	private String productLine;
	@Column(name = "productscale")
	private String productScale;
	@Column(name = "productvendor")
	private String productVendor;
	@Column(name = "productdescription")
	private String productDescription;
	@Column(name = "quantityinstock")
	private Integer quantityInStock;
	@Column(name = "buyprice")
	private Double buyPrice;
	@Column(name = "msrp")
	private Double MSRP;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getMSRP() {
		return MSRP;
	}

	public void setMSRP(Double mSRP) {
		MSRP = mSRP;
	}

}
