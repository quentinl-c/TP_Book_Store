package com.polytechnancy.bookstore.data.dao;

import java.util.List;

import javax.ejb.Local;

import com.polytechnancy.bookstore.data.entities.Book;

@Local
public interface BooksDAO {

	public List<Book> findAll();
	public Book findByISBN(String isbn);
	public void create(String isbn, String title, String author, double price);

}
