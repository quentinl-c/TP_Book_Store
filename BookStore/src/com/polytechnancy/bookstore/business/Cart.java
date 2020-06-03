package com.polytechnancy.bookstore.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.polytechnancy.bookstore.data.entities.LineItem;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<LineItem> items;
	
	public Cart() {
		this.items = new ArrayList<LineItem>();
	}

	public ArrayList<LineItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<LineItem> items) {
		this.items = items;
	}
	
	public boolean isEmpty() {
		return this.items.isEmpty();
	}
	
	public void addItem(LineItem item) {
		String code = item.getBook().getIsbn();
		int quantity = item.getQuantity();

		for(LineItem lineItem : this.items) {

			if(lineItem.getBook().getIsbn().equals(code)) {
				lineItem.setQuantity(quantity);
				return;
			}
		}
		this.items.add(item);
	}
	
	public void removeItem(String code) {
		Iterator<LineItem> itr = this.items.iterator();
		while(itr.hasNext()) {
			if(itr.next().getBook().getIsbn().equals(code)) {
				itr.remove();
				return;
			}
		}
	}
	
	public double getTotal() {
		double res = 0.0;
		for(LineItem lineItem : this.items) {
			res += lineItem.getTotal();
		}
		return res;
	}

}
