package com.cameronsmith.show.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cameronsmith.show.bookmodels.Book;
import com.cameronsmith.show.bookservices.BookService;

@RestController
@RequestMapping("/api")
public class APIController {
	@Autowired
	private BookService bService;
	@GetMapping("/books")
	public List<Book> allBooks(){
		return this.bService.getAllBooks();
	}
	@GetMapping("/books/{id}")
	public Book getOneBook(@PathVariable("id")Long id) {
		return this.bService.individualBook(id);
	}
	@PostMapping("/books")
	public Book createBook(Book newBook) {
		return this.bService.createBook(newBook);
	}
	@PutMapping("/books/update/{id}")
	public Book updateBook(@PathVariable("id")Long id, Book updatedBoook) {
		return this.bService.updateBook(id, updatedBoook);
	}
	@DeleteMapping("/books/delete/{id}")
	public void deleteBook(@PathVariable("id")Long id) {
		this.bService.deleteBook(id);
	}
}
