package model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String details;
	private String imageURL;
	private String price;

	public Book() {
		super();
	}
	

	public Book(String title, String author, String details, String imageURL, String price) {
		super();
		this.title = title;
		this.author = author;
		this.details = details;
		this.imageURL = imageURL;
		this.price = price;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
