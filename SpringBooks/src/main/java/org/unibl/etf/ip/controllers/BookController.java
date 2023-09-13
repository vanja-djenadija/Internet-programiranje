package org.unibl.etf.ip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unibl.etf.ip.entities.Book;
import org.unibl.etf.ip.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping
	public @ResponseBody List<Book> getAll(){
		return service.getAll();
	}
}
