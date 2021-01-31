package com.cameronsmith.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cameronsmith.show.bookmodels.Book;
import com.cameronsmith.show.bookservices.BookService;

@Controller
public class BooksController {
	@Autowired
	private BookService bService;
	@RequestMapping("/books")
    public String index(Model viewModel) {
        List<Book> books = bService.getAllBooks();
        viewModel.addAttribute("books", books);
        return "books.jsp";
	}
	@RequestMapping("/books/{id}")
    public String findBookByIndex(Model viewModel, @PathVariable("id") Long id) {
        Book book = bService.individualBook(id);
        viewModel.addAttribute("book", book);
        return "showBook.jsp";
    }
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    @RequestMapping(value="/addBooks", method=RequestMethod.POST)
    public String createBook(@Valid @ModelAttribute("book")Book book, BindingResult result) {
    		if (result.hasErrors()) {
            return "new.jsp";
        } 
        this.bService.createBook(book);
        return "redirect:/books";
    }
}
