package com.example.Spring_project_new.Project1.services;

import com.example.Spring_project_new.Project1.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book(12,"java","Xyz"));
        list.add(new Book(22,"Spring","Xuz"));
        list.add(new Book(32,"mysql","Abn"));
    }
    public List<Book>getAllBook(){
        return list;
    }
    public Book getBookById(int id){
        Book book= null;
     list.stream().filter(e->e.getId()==id).findFirst().get();
     return book;
    }
    public Book addBook(Book b){
        list.add(b);
        return b;
    }
    //delete book
//    public void deleteBook(int bid){
//        list.stream().filter(book -> {
//            if (book.getId()!=bid){
//                return true;
//            }else{
//                return false;
//            }
//        }).collect(Collectors.toList());
    public void deleteBook(int bid){
        list=list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
    }
    //update the book
    public  void updateBook(Book book, int bookId){
        list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
