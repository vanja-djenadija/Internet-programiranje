package dao;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Book;


public class BookDAO {

	private static final String sep = "#";
	private URI booksURI;
	
	public BookDAO(URI booksURI) {
		this.booksURI = booksURI;
	}

	public List<Book> getAll() {
		List<Book> books = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Path.of(booksURI));
			for (String line : lines) {
				String[] parts = line.split(sep);
				books.add(new Book(parts[0], parts[1], parts[2], parts[3], parts[4]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
}
