package com.example.Spring_project_new.Project1.controller;


import com.example.Spring_project_new.Project1.entity.Book;
import com.example.Spring_project_new.Project1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    //get all boos handler
    @GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookService.getAllBook();
    }
    //Single Book-----------------
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id")int id){
        return bookService.getBookById(id);
    }
    //new book handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b=this.bookService.addBook(book);
        return b;
    }
    //update book handler
    @PutMapping("/books/{Id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }
    //delete book handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId")int bookId){
        this.bookService.deleteBook(bookId);
    }
}

