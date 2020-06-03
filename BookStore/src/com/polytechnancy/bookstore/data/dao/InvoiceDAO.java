package com.polytechnancy.bookstore.data.dao;

import java.util.List;

import javax.ejb.Local;

import com.polytechnancy.bookstore.data.entities.LineItem;

@Local
public interface InvoiceDAO {
	
	public void create(String name, String address, List<LineItem> items);

}
