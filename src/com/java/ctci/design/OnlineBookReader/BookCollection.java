package com.java.ctci.design.OnlineBookReader;

import java.util.HashMap;

/**
 * Created by richa on 1/13/17.
 *
 */
public class BookCollection {

    private HashMap<Integer, Book> books;

    private int totalBooks;

    public void addBook(Book book){

    }

    public Book removeBook(Integer bookId){
        return null;
    }

    public Book searchBook(Integer bookId){
        return books.get(bookId);
    }
}
