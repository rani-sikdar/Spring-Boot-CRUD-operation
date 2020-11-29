package com.example.demo.controller;

import com.example.demo.repo.BookRepository;

import antlr.collections.List;

import com.example.demo.model.Book;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
public class BookController {
	
	@Autowired 
	BookRepository bookRepository;
	
	
	//Create operation
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "record inserted sucessfully";	
	}
	

	@PostMapping("/multipleBookSave")
	public String insertBook(@RequestBody List book) {
		bookRepository.saveAll(book);
		return "record saved sucessfully";	
	}
	
	//Read operation
	@GetMapping("/getAllBook")
	public List getBook() {
		return List<Book> bookRepository.findAll();
	}
	@GetMapping("/getByBookName")
	public List getBook(@PathVariable("name") String bookName) {
		return List<Book> bookRepository.findBybookName();
	}
	@GetMapping("/getBookById{bookId}")
	public Optional<Book> getBook(@PathVariable("bookId") Long id ){
		return  bookRepository.findById(id);
	}
	
	//update operation
	@PutMapping("/updateBook/{id}")
	public bookRepository<?> update(@RequestBody Book book, @PathVariable Integer id) {
	    
	        Book b = bookRepository.get(id);
	        bookRepository.save(book);
	        return new bookRepository<>(HttpStatus.OK);
	         
	}
	
	
	//delete operation
	@DeleteMapping("/deleteBook/{id}")
	public void delete(@PathVariable BookId id) {
		bookRepository.delete(id);
	}
	

}
