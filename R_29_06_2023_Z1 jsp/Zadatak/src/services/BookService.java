package services;

import java.util.ArrayList;
import java.util.List;

import models.Book;

public class BookService {
	
	public List<Book> books = new ArrayList<>();
	
	private static BookService instance = null;
	
	public static BookService getInstance() {
		if(instance == null)
			instance = new BookService();
		return instance;
	}
	
	private BookService() {
		super();
	}
}
