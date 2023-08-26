package org.unibl.etf.ip.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.unibl.etf.ip.model.Book;

public class BookDAO {

	private final String bookPath;
	
	public BookDAO(String bookPath) {
		// TODO Auto-generated constructor stub
		this.bookPath = bookPath;
	}
	
	public List<Book> getAll() {
		ArrayList<Book> books = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(bookPath))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] data = line.split("##");
				books.add(new Book(data[0], data[1], data[2], data[3], data[4]));
			}
			return books;
		} catch (IOException | ArrayIndexOutOfBoundsException ex) {
			return new ArrayList<>();
		}
	}

}
