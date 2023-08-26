package org.unibl.etf.ip.model;

public class Book {

	private String isbn, title, author, imageLink, detailsLink;

	public Book() {
	}

	public Book(String isbn, String title, String author, String imageLink, String detailsLink) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.imageLink = imageLink;
		this.detailsLink = detailsLink;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDetailsLink() {
		return detailsLink;
	}

	public void setDetailsLink(String detailsLink) {
		this.detailsLink = detailsLink;
	}

}
