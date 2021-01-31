package com.cameronsmith.show.bookservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cameronsmith.show.bookmodels.Book;
import com.cameronsmith.show.bookrepositories.BookRepo;

@Service
public class BookService {
	private BookRepo bRepo;
	
	public BookService(BookRepo bookRepo) {
		this.bRepo = bookRepo;
	}
	public List<Book> getAllBooks(){
		return this.bRepo.findAll();
	}
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	public Book createBook(String title, String description, String author, String language, int numberOfPages) {
		Book newBook = new Book(title, description, author, language, numberOfPages);
		return this.bRepo.save(newBook);
	}
	public Book individualBook(Long id) {
    	return this.bRepo.findById(id).orElse(null);
	}
	public Book updateBook(Long id, Book bookToUpdate) {
		return this.bRepo.save(bookToUpdate);
	}
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
}
