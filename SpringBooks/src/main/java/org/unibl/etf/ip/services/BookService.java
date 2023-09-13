package org.unibl.etf.ip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.entities.Book;
import org.unibl.etf.ip.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	
	public List<Book> getAll() {
		return repo.findAll();
	}
	
}
