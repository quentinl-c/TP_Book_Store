package com.polytechnancy.bookstore.data.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.polytechnancy.bookstore.data.dao.BooksDAO;
import com.polytechnancy.bookstore.data.entities.Book;

@Stateless
public class BooksDAOImpl implements BooksDAO {
	
	@PersistenceContext(unitName="BookstorePU")
	private EntityManager em;
	
	public List<Book> findAll() {
		return em.createQuery( "SELECT b FROM Book b ORDER BY b.title", Book.class).getResultList();
	}
	
	public Book findByISBN(String isbn) {
		return em.find(Book.class, isbn);
	}
	
	public void create(String isbn, String title, String author, double price) {
		Book book = new Book(isbn, title, author, price);
		em.persist(book);
	}

}
