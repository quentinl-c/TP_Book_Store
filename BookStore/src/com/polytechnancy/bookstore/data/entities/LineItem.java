package com.polytechnancy.bookstore.data.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "line_item")
public class LineItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private Invoice invoice;

	private Book book;

	private int quantity;
	
	public LineItem() {}

	
	public LineItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}


	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotal() {
		double total = this.book.getPrice() * this.quantity;
		return total;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
}
