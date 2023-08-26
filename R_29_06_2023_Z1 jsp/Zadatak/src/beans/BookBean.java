package beans;

import java.util.List;

import models.Book;
import services.BookService;

public class BookBean {

	BookService bookService = BookService.getInstance();
	
	public BookBean() {
		super();
	}
	
	public void addBook(Book book) {
		System.out.println("Dodaj knjigu " + book);
		bookService.books.add(book);
	}
	
	public List<Book> getBooks() {
		return bookService.books;
	}
	
	public Book findBook(String bookName) {
		for(Book b: bookService.books) {
			if(b.getNaslov().equals(bookName)) {
				return b;
			}
		}
		return null;
	}
}
